package org.cchao.http;

import com.core.frame.utils.Md5Utils;
import com.core.frame.utils.jsonutils.JsonUtils;
import org.cchao.http.db.CacheDbUtils;
import org.cchao.http.db.CacheModel;

import io.reactivex.functions.Consumer;

/**
 * @author cchen6
 * @Date on 2019/8/5
 * @Description
 */
class CacheConsumer implements Consumer<HttpResponseModel<Object>> {

    private HttpRequestBody httpRequestBody;

    private boolean isCache;

    CacheConsumer(HttpRequestBody httpRequestBody, boolean isCache) {
        this.httpRequestBody = httpRequestBody;
        this.isCache = isCache;
    }

    @Override
    public void accept(HttpResponseModel<Object> objectHttpResponseModel) {
        if (!isCache || null == objectHttpResponseModel || !objectHttpResponseModel.isSuccess()) {
            return;
        }
        String key = Md5Utils.getMd5(JsonUtils.toString(httpRequestBody));
        CacheModel cacheModel = CacheDbUtils.getInstance().queryCacheModel(key);
        if (null == cacheModel) {
            cacheModel = new CacheModel(key, JsonUtils.toString(objectHttpResponseModel.getData()), objectHttpResponseModel.getCode(), objectHttpResponseModel.getMsg(), System.currentTimeMillis());
            CacheDbUtils.getInstance().saveCache(cacheModel);
        } else {
            cacheModel.setTime(System.currentTimeMillis());
            cacheModel.setContent(JsonUtils.toString(objectHttpResponseModel.getData()));
            cacheModel.setCode(objectHttpResponseModel.getCode());
            cacheModel.setMsg(objectHttpResponseModel.getMsg());
        }
    }
}
