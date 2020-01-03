package com.jjshouse.kotlinmvvpdemo.base.constants

import com.jjshouse.kotlinmvvpdemo.BuildConfig


object Key {

    val ADDRESS_BEAN = "address_bean"
    val ADDRESS_CHECKOUT = "address_checkout"
    val ADDRESS_ID = "address_id"
    val APP_INIT_BUNDLE = "app_init_bundle"
    val APP_INIT_FLAG = "app_init_flag"
    val APP_REG_DES_FLAG = "app_register_description_title"
    val BANNER_HOME_PIC_FLAG = "banner_home_pic_flag"
    val CART_GUIDE_FLAG = "cart_guide_flag"
    val CART_QUANTITY_IN_COOKIE = "app_cart_qty"
    val CHECKOUT_GOODSLIST = "checkout_goods_list"
    val COMMON_BACK_TEXT = "common_back_text"
    val COMMON_DATA = "common_data"
    val COMMON_PAGE_FLAG = "common_web_flag"
    val COMMON_PAGE_TYPE = "common_page_type"
    val COMMON_TITLE = "web_title"
    val COUNTRY_CODE = "fd_country_code"
    val COUNTRY_NAME = "fd_country_name"
    val CURRENCY = "currency"
    val CURRENT_API_HOST = "current_api_host"
    val CURRENT_HOST = "current_host"
    val CURRENT_VERSION = "current_version"
    val DAY_INDEX = "flash_sale_day_index"
    val DEVICE_APPSFLYER_ID = "appsflyer_id"
    val DEVICE_IDFA = "idfa"
    val DEVICE_IDFV = "idfv"
    val DEVICE_UA_CHANNEL_ID = "ua_channel_id"
    val DIALOG_ATY_DATA = "dialog_aty_data"
    val EVENT = "event"
    val HOME_TABS = arrayOf("home", "category", "newarrivals", "flashsale", "account")
    val IS_LAUNCHE_FROM_CHECKOUT_FLAG = "is_launche_from_checkout_flag"
    val IS_NO_PAID = "is_no_paid"
    val IS_TRY_AGAIN = "is_try_again"
    val LANGUAGE = "language"
    val LAUNCHER_FROM_CATEGORY = 2
    val LAUNCHER_FROM_HOME = 1
    val LAUNCHER_IN_HROME = 3
    val LAUNCH_FLAG = "launch_flag"
    val LOGIN_IN_WEB_FLAG = "if_need_login"
    val LOGIN_REQUEST_CODE = 51
    val NEW_ROUTE_SG = "new_route_sg"
    val ORDER_FROM_PAY = "order_from_pay"
    val ORDER_HELP_PARCEL_DATA = "order_help_parcel_data"
    val ORDER_PAID_NOSIHPPED_CANCEL_FLAG = "order_paid_noshipped_cancel_flag"
    val ORDER_PLACE_TIME = "order_place_time"
    val ORDER_SN = "order_sn"
    val PAYMENTINFO = "payment_info"
    val PAYMENT_ID = "payment_id"
    val PAY_CODE = "pay_code"
    val PUSH_FIRST_RUN = "push_first_run"
    val REC_ID_LIST = "rec_ids"
    val ROUTE_SN = "route_sn"
    val SELECT_TAB = "select_tab"
    val SP_NAME = "vv_sharedpreferences"
    val UA_PUSH_URL = "ua_push_url"
    val UPDATE_LAST_NOTICE_TIME = "update_last_notice_time"
    val USERID_IN_COOKIE = "post_id"
    val USER_COUPON_LIST = "user_coupon_list"
    val USER_COUPON_SELECTED_POS = "user_coupon_selected_pos"
    val USER_EMAIL = "user_email"
    val USER_ID = "user_id"
    val USER_PASSWORD = "user_password"
    val VIRTUAL_GOODS_ID = "virtual_goods_id"
    val VIRTUAL_GOODS_THUMB_DEFAULT_URL = "virtual_goods_id_default_url"
    val VIRTUAL_GOODS_URL = "virtual_goods_url"
    val WEB_URL = "web_url"

    val USER_LANGUAGE = "user_language"
    val USER_LANGUAGE_FULL_NAME = "user_language_full_name"
    val USER_CURRENCY = "user_currency"
    val USER_COUNTRY = "user_country"
    val USER_DEFAULT_LANGUAGE = ""
    val USER_DEFAULT_CURRENCY = ""
    val USER_DEFAULT_COUNTRY = "Germany"
    val USER_LAUNCH_COUNT = "user_launch_count"
    val USER_COUNTRY_UCID = "user_country_ucid"

    val LANGUAGE_LIST = "language_list"
    val CURRENCY_LIST = "currency_list"
    val COUNTRY_LIST = "country_list"

    val IMAGE_CHOOSER_RESULT_CODE = 4


    val CAMPAIGN_SOURCE_PARAM = "utm_source"
    val CAMPAIGN_MEDIUM_PARAM = "utm_medium"
    val CAMPAIGN_CAMPAIGN_PARAM = "utm_campaign"


    //eventbus message key
    val LOGIN_OUT = "login_out"
    val LOGIN_OK ="login_ok"
    val REFRESH_FAVORITE="refresh_favorite"
    val ADD_ACTIVITY="add_activity"
    val LOGIN_STATUS="login_status"
    val APP_CACHE_DIRNAME = "/webcache"

    val HOST_KEY = BuildConfig.DOMAIN

    val SEARCH_HISTORY="serach_history"
    val USER_LOGIN_STATUS="user_login_status"
    val HOME_DIALOG_SHOW_TIME="home_dialog_show_time"

    val BAG_COUNT = "bag_count"
    val LOVE_COUNT = "love_count"
    val GOODS_MIX_PAGE= "goods_mix_page"
    val GOODS_VISIT_HISTORY = "goods_visit_history"
    val ACCOUNT_INFO: String = "account_info"

    // V2.6.0
    val IS_TODAY_FIRST_SHOW = "is_today_first_show"
    val CLOSE_COUPON_DIALOG_COUNT = "close_coupon_dialog_count"
    val CLEAR_COUPON_CACHE_TIMESTAMP = "clear_coupon_cache_timestamp"
    val USER_INFO = "user_info"
    val FCM_TOKEN = "fcm_token"

    // V3.0.0
    val LIKE_HISTORY = "like_history"
}
