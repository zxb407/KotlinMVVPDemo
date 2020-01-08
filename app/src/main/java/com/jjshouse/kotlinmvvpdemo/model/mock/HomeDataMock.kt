package com.jjshouse.kotlinmvvpdemo.model.mock

import com.google.gson.Gson
import com.jjshouse.kotlinmvvpdemo.model.databean.HomeDataBean

/**
 * PackageName: com.veryvoga.vv.data
 * Created by xbzhang on 2019/1/23
 * Description:
 *
 */
class HomeDataMock private constructor() {

    fun getHomeData(): HomeDataBean {
        var json: String = """
{
        "slogan": {
            "hasBanner": false,
            "showTimer": false,
            "styleConf": {
                "width": 0,
                "height": 0,
                "background": "#ece0c8",
                "textColor": "#841d0e"
            },
            "content": [
                {
                    "url": "Cheap-Sales-c1010/",
                    "text": "<strong style='color:#841d0e'>OFFRE SPÉCIALE&nbsp;</strong>· JUSQU'À - 80%",
                    "image": "",
                    "nativeConfig": {
                        "nativeUrl": "",
                        "filter": "",
                        "type": 4,
                        "gid": "",
                        "from": 0
                    }
                }
            ]
        },
        "banners": [
            {
                "type": 1,
                "columnNum": 0,
                "config": [
                    {
                        "key": "",
                        "listType": 2,
                        "width": 1029,
                        "height": 1014,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/banner.png",
                        "url": "/Robes-c199/",
                        "nativeConfig": {
                            "nativeUrl": "/api/v1/c1/list/common/199",
                            "filter": "",
                            "type": 1,
                            "gid": "",
                            "from": 2
                        }
                    }
                ]
            },
            {
                "type": 1,
                "columnNum": 0,
                "config": [
                    {
                        "key": "",
                        "listType": 2,
                        "width": 1029,
                        "height": 1014,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/banner.png",
                        "url": "/Robes-c199/",
                        "nativeConfig": {
                            "nativeUrl": "/api/v1/c1/list/common/199",
                            "filter": "",
                            "type": 1,
                            "gid": "",
                            "from": 2
                        }
                    }
                ]
            },
            {
                "type": 2,
                "columnNum": 3,
                "config": [
                    {
                        "key": "",
                        "listType": 2,
                        "width": 345,
                        "height": 429,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-11-01/images/banners/IndexCategoryPic/IndexCategoryPic/dresses.png",
                        "url": "/Robes-c199/",
                        "nativeConfig": {
                            "nativeUrl": "/api/v1/c1/list/common/199",
                            "filter": "",
                            "type": 1,
                            "gid": "",
                            "from": 2
                        }
                    },
                    {
                        "key": "",
                        "listType": 2,
                        "width": 345,
                        "height": 429,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-11-01/images/banners/IndexCategoryPic/IndexCategoryPic/sweaters.png",
                        "url": "/Pulls-c1002/",
                        "nativeConfig": {
                            "nativeUrl": "/api/v1/c1/list/common/1002",
                            "filter": "",
                            "type": 1,
                            "gid": "",
                            "from": 2
                        }
                    },
                    {
                        "key": "",
                        "listType": 2,
                        "width": 345,
                        "height": 429,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-11-01/images/banners/IndexCategoryPic/IndexCategoryPic/blouses.png",
                        "url": "/Blouses-c1003/",
                        "nativeConfig": {
                            "nativeUrl": "/api/v1/c1/list/common/1003",
                            "filter": "",
                            "type": 1,
                            "gid": "",
                            "from": 2
                        }
                    },
                    {
                        "key": "",
                        "listType": 2,
                        "width": 345,
                        "height": 429,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-11-01/images/banners/IndexCategoryPic/IndexCategoryPic/clothing.png",
                        "url": "/Vetements-c1000/",
                        "nativeConfig": {
                            "nativeUrl": "/api/v1/c1/list/common/1000",
                            "filter": "",
                            "type": 1,
                            "gid": "",
                            "from": 2
                        }
                    },
                    {
                        "key": "",
                        "listType": 2,
                        "width": 345,
                        "height": 429,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-11-01/images/banners/IndexCategoryPic/IndexCategoryPic/shoes.png",
                        "url": "/Chaussures-c84/",
                        "nativeConfig": {
                            "nativeUrl": "/api/v1/c1/list/common/84",
                            "filter": "",
                            "type": 1,
                            "gid": "",
                            "from": 2
                        }
                    },
                    {
                        "key": "",
                        "listType": 2,
                        "width": 345,
                        "height": 429,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-11-01/images/banners/IndexCategoryPic/IndexCategoryPic/acc.png",
                        "url": "/Accessoires-c5/",
                        "nativeConfig": {
                            "nativeUrl": "/api/v1/c1/list/common/5",
                            "filter": "",
                            "type": 1,
                            "gid": "",
                            "from": 2
                        }
                    }
                ]
            },
            {
                "type": 4,
                "columnNum": 0,
                "config": [
                    {
                        "key": "",
                        "listType": 2,
                        "width": 750,
                        "height": 200,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-05-15/images/banners/newusers/newusers/fr.jpg",
                        "url": "/register.php",
                        "nativeConfig": {
                            "nativeUrl": "",
                            "filter": "",
                            "type": 4,
                            "gid": "",
                            "from": 0
                        }
                    }
                ]
            },
            {
                "type": 2,
                "columnNum": 3,
                "config": [
                    {
                        "key": "",
                        "listType": 2,
                        "width": 345,
                        "height": 429,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-11-01/images/banners/IndexCategoryPic/IndexCategoryPic/dresses.png",
                        "url": "/Robes-c199/",
                        "nativeConfig": {
                            "nativeUrl": "/api/v1/c1/list/common/199",
                            "filter": "",
                            "type": 1,
                            "gid": "",
                            "from": 2
                        }
                    },
                    {
                        "key": "",
                        "listType": 2,
                        "width": 345,
                        "height": 429,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-11-01/images/banners/IndexCategoryPic/IndexCategoryPic/sweaters.png",
                        "url": "/Pulls-c1002/",
                        "nativeConfig": {
                            "nativeUrl": "/api/v1/c1/list/common/1002",
                            "filter": "",
                            "type": 1,
                            "gid": "",
                            "from": 2
                        }
                    },
                    {
                        "key": "",
                        "listType": 2,
                        "width": 345,
                        "height": 429,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-11-01/images/banners/IndexCategoryPic/IndexCategoryPic/blouses.png",
                        "url": "/Blouses-c1003/",
                        "nativeConfig": {
                            "nativeUrl": "/api/v1/c1/list/common/1003",
                            "filter": "",
                            "type": 1,
                            "gid": "",
                            "from": 2
                        }
                    },
                    {
                        "key": "",
                        "listType": 2,
                        "width": 345,
                        "height": 429,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-11-01/images/banners/IndexCategoryPic/IndexCategoryPic/clothing.png",
                        "url": "/Vetements-c1000/",
                        "nativeConfig": {
                            "nativeUrl": "/api/v1/c1/list/common/1000",
                            "filter": "",
                            "type": 1,
                            "gid": "",
                            "from": 2
                        }
                    },
                    {
                        "key": "",
                        "listType": 2,
                        "width": 345,
                        "height": 429,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-11-01/images/banners/IndexCategoryPic/IndexCategoryPic/shoes.png",
                        "url": "/Chaussures-c84/",
                        "nativeConfig": {
                            "nativeUrl": "/api/v1/c1/list/common/84",
                            "filter": "",
                            "type": 1,
                            "gid": "",
                            "from": 2
                        }
                    },
                    {
                        "key": "",
                        "listType": 2,
                        "width": 345,
                        "height": 429,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-11-01/images/banners/IndexCategoryPic/IndexCategoryPic/acc.png",
                        "url": "/Accessoires-c5/",
                        "nativeConfig": {
                            "nativeUrl": "/api/v1/c1/list/common/5",
                            "filter": "",
                            "type": 1,
                            "gid": "",
                            "from": 2
                        }
                    }
                ]
            },
            {
                "type": 1,
                "columnNum": 0,
                "config": [
                    {
                        "key": "",
                        "listType": 2,
                        "width": 750,
                        "height": 400,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/newbanner.png",
                        "url": "/new-arrival/",
                        "nativeConfig": {
                            "nativeUrl": "/api/v1/c1/list/common/1",
                            "filter": "",
                            "type": 1,
                            "gid": "",
                            "from": 2
                        }
                    }
                ]
            },
                        {
                "type": 1,
                "columnNum": 0,
                "config": [
                    {
                        "key": "",
                        "listType": 2,
                        "width": 750,
                        "height": 400,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/newbanner.png",
                        "url": "/new-arrival/",
                        "nativeConfig": {
                            "nativeUrl": "/api/v1/c1/list/common/1",
                            "filter": "",
                            "type": 1,
                            "gid": "",
                            "from": 2
                        }
                    }
                ]
            },
                        {
                "type": 1,
                "columnNum": 0,
                "config": [
                    {
                        "key": "",
                        "listType": 2,
                        "width": 750,
                        "height": 400,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/newbanner.png",
                        "url": "/new-arrival/",
                        "nativeConfig": {
                            "nativeUrl": "/api/v1/c1/list/common/1",
                            "filter": "",
                            "type": 1,
                            "gid": "",
                            "from": 2
                        }
                    }
                ]
            },
            {
                "type": 6,
                "columnNum": 0,
                "config": [
                    {
                        "key": "",
                        "listType": 2,
                        "width": 498,
                        "height": 660,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/newdresses.png",
                        "url": "/Robes-c199/new-arrival/",
                        "nativeConfig": {
                            "nativeUrl": "/api/v1/c1/list/common/199",
                            "filter": "new-arrival",
                            "type": 1,
                            "gid": "",
                            "from": 2
                        }
                    },
                    {
                        "key": "",
                        "listType": 2,
                        "width": 501,
                        "height": 318,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/newsweaters.png",
                        "url": "/Pulls-c1002/new-arrival/",
                        "nativeConfig": {
                            "nativeUrl": "/api/v1/c1/list/common/1002",
                            "filter": "new-arrival",
                            "type": 1,
                            "gid": "",
                            "from": 2
                        }
                    },
                    {
                        "key": "",
                        "listType": 2,
                        "width": 501,
                        "height": 318,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/newblouses.png",
                        "url": "/Blouses-c1003/new-arrival/",
                        "nativeConfig": {
                            "nativeUrl": "/api/v1/c1/list/common/1003",
                            "filter": "new-arrival",
                            "type": 1,
                            "gid": "",
                            "from": 2
                        }
                    }
                ]
            },

            {
                "type": 5,
                "allUrl": "/Maillots-De-Bain-c202/new-arrival/",
                "allText": "Tout Afficher",
                "title": "Nouveautés",
                "columnNum": 0,
                "config": [
                    {
                        "goodsId": "276853",
                        "image": "https://imgs.veryvoga.com/s330/72/5c/c6508044c85494dc998b68a5ef21725c.jpg",
                        "url": "/Fleuris-Feuilles-Dos-Nu-Frais-Mignon-Bikinis-Maillots-De-Bain-202276853-g276853?la=sidebar",
                        "goodsImg": "72/5c/c6508044c85494dc998b68a5ef21725c.jpg",
                        "shopPrice": "24,45 €",
                        "isRectangle": 1
                    },
                    {
                        "goodsId": "276850",
                        "image": "https://imgs.veryvoga.com/s330/36/cb/b62951eebc254b5481f29832646d36cb.jpg",
                        "url": "/Feuilles-Dos-Nu-Attrayant-Mignon-Bikinis-Maillots-De-Bain-202276850-g276850?la=sidebar",
                        "goodsImg": "36/cb/b62951eebc254b5481f29832646d36cb.jpg",
                        "shopPrice": "24,45 €",
                        "isRectangle": 1
                    },
                    {
                        "goodsId": "276851",
                        "image": "https://imgs.veryvoga.com/s330/3f/70/8680dfafaeb55f930733a0b687733f70.jpg",
                        "url": "/Colore-Dos-Nu-Classique-Mignon-Bikinis-Maillots-De-Bain-202276851-g276851?la=sidebar",
                        "goodsImg": "3f/70/8680dfafaeb55f930733a0b687733f70.jpg",
                        "shopPrice": "24,74 €",
                        "isRectangle": 1
                    },
                    {
                        "goodsId": "276852",
                        "image": "https://imgs.veryvoga.com/s330/2d/90/da68db2372cda8dba94c0a6c57e52d90.jpg",
                        "url": "/Fleuris-Feuilles-Dos-Nu-Jolis-Mignon-Bikinis-Maillots-De-Bain-202276852-g276852?la=sidebar",
                        "goodsImg": "2d/90/da68db2372cda8dba94c0a6c57e52d90.jpg",
                        "shopPrice": "24,74 €",
                        "isRectangle": 1
                    },
                    {
                        "goodsId": "276819",
                        "image": "https://imgs.veryvoga.com/s330/e1/20/4c362d5317d3c320622d8a2de08ce120.jpg",
                        "url": "/Feuilles-Dos-Nu-A-La-Mode-Mignon-Bikinis-Maillots-De-Bain-202276819-g276819?la=sidebar",
                        "goodsImg": "e1/20/4c362d5317d3c320622d8a2de08ce120.jpg",
                        "shopPrice": "24,74 €",
                        "isRectangle": 1
                    },
                    {
                        "goodsId": "276814",
                        "image": "https://imgs.veryvoga.com/s330/f5/ec/03d6da31c6d5f05e9203f680dcbaf5ec.jpg",
                        "url": "/Colore-A-Bretelles-Sexy-Mignon-Bikinis-Maillots-De-Bain-202276814-g276814?la=sidebar",
                        "goodsImg": "f5/ec/03d6da31c6d5f05e9203f680dcbaf5ec.jpg",
                        "shopPrice": "24,74 €",
                        "isRectangle": 1
                    },
                    {
                        "goodsId": "276815",
                        "image": "https://imgs.veryvoga.com/s330/97/68/794e6cbe0e103aaca0212e4ddc9b9768.jpg",
                        "url": "/Feuilles-A-Bretelles-Frais-Attrayant-Bikinis-Maillots-De-Bain-202276815-g276815?la=sidebar",
                        "goodsImg": "97/68/794e6cbe0e103aaca0212e4ddc9b9768.jpg",
                        "shopPrice": "24,74 €",
                        "isRectangle": 1
                    },
                    {
                        "goodsId": "276816",
                        "image": "https://imgs.veryvoga.com/s330/8b/6f/ec47f2625af1db091cb92c1318e18b6f.jpg",
                        "url": "/Feuilles-A-Bretelles-Classique-Attrayant-Bikinis-Maillots-De-Bain-202276816-g276816?la=sidebar",
                        "goodsImg": "8b/6f/ec47f2625af1db091cb92c1318e18b6f.jpg",
                        "shopPrice": "24,74 €",
                        "isRectangle": 1
                    },
                    {
                        "goodsId": "276817",
                        "image": "https://imgs.veryvoga.com/s330/14/d9/c308540591844f1299149c14027a14d9.jpg",
                        "url": "/Fleuris-A-Bretelles-Sexy-Bikinis-Maillots-De-Bain-202276817-g276817?la=sidebar",
                        "goodsImg": "14/d9/c308540591844f1299149c14027a14d9.jpg",
                        "shopPrice": "23,79 €",
                        "isRectangle": 1
                    },
                    {
                        "goodsId": "276818",
                        "image": "https://imgs.veryvoga.com/s330/f4/9c/a495c3ba1859e0e6c15570a575aff49c.jpg",
                        "url": "/Feuilles-A-Bretelles-Sexy-Bikinis-Maillots-De-Bain-202276818-g276818?la=sidebar",
                        "goodsImg": "f4/9c/a495c3ba1859e0e6c15570a575aff49c.jpg",
                        "shopPrice": "23,60 €",
                        "isRectangle": 1
                    },
                    {
                        "goodsId": "276820",
                        "image": "https://imgs.veryvoga.com/s330/d6/d9/192c2a67a8630fbe6c9c32ef8c9cd6d9.jpg",
                        "url": "/Fleuris-Feuilles-A-Bretelles-Sexy-Bikinis-Maillots-De-Bain-202276820-g276820?la=sidebar",
                        "goodsImg": "d6/d9/192c2a67a8630fbe6c9c32ef8c9cd6d9.jpg",
                        "shopPrice": "23,79 €",
                        "isRectangle": 1
                    },
                    {
                        "goodsId": "276812",
                        "image": "https://imgs.veryvoga.com/s330/3c/32/22043c639ca398b33b3cc1707c333c32.jpg",
                        "url": "/Fleuris-Feuilles-Dos-Nu-Mignon-Bikinis-Maillots-De-Bain-202276812-g276812?la=sidebar",
                        "goodsImg": "3c/32/22043c639ca398b33b3cc1707c333c32.jpg",
                        "shopPrice": "23,60 €",
                        "isRectangle": 1
                    }
                ],
                "nativeConfig": {
                    "nativeUrl": "/api/v1/c1/list/common/202",
                    "filter": "new-arrival",
                    "type": 1,
                    "gid": "",
                    "from": 0
                }
            },

            {
                "type": 13,
                "title": "style gallery",
                "img": "7b/a2/a34231664009c299cd064a42f6647ba2",
                "galleryConfig": [
                  {
                    "galleryId": 15613,
                    "img": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/newdresses.png",
                    "favourite": 74,
                    "isFavourite": false
                  },
                  {
                    "galleryId": 15610,
                    "img": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/newdresses.png",
                    "favourite": 117,
                    "isFavourite": false
                  },
                  {
                    "galleryId": 15610,
                    "img": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/newdresses.png",
                    "favourite": 117,
                    "isFavourite": false
                  },
                  {
                    "galleryId": 15185,
                    "img": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/newdresses.png",
                    "favourite": 117,
                    "isFavourite": false
                  },
                  {
                    "galleryId": 15795,
                    "img": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/newdresses.png",
                    "favourite": 88,
                    "isFavourite": false
                  },
                  {
                    "galleryId": 16794,
                    "img": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/newdresses.png",
                    "favourite": 154,
                    "isFavourite": false
                  },
                  {
                    "galleryId": 15784,
                    "img": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/newdresses.png",
                    "favourite": 90,
                    "isFavourite": false
                  },
                  {
                    "galleryId": 65478,
                    "img": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/newdresses.png",
                    "favourite": 1112,
                    "isFavourite": false
                  },
                  {
                    "galleryId": 54782,
                    "img": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/newdresses.png",
                    "favourite": 117,
                    "isFavourite": false
                  },
                  {
                    "galleryId": 54955,
                    "img": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/newdresses.png",
                    "favourite": 117,
                    "isFavourite": false
                  },
                  {
                    "galleryId": 64887,
                    "img": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/newdresses.png",
                    "favourite": 10,
                    "isFavourite": false
                  },
                  {
                    "galleryId": 48822,
                    "img": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/newdresses.png",
                    "favourite": 197,
                    "isFavourite": false
                  }
                ]
            }
            ,{
                "type": 6,
                "columnNum": 0,
                "config": [
                    {
                        "key": "",
                        "listType": 2,
                        "width": 498,
                        "height": 660,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/newdresses.png",
                        "url": "/Robes-c199/new-arrival/",
                        "nativeConfig": {
                            "nativeUrl": "/api/v1/c1/list/common/199",
                            "filter": "new-arrival",
                            "type": 1,
                            "gid": "",
                            "from": 2
                        }
                    },
                    {
                        "key": "",
                        "listType": 2,
                        "width": 501,
                        "height": 318,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/newsweaters.png",
                        "url": "/Pulls-c1002/new-arrival/",
                        "nativeConfig": {
                            "nativeUrl": "/api/v1/c1/list/common/1002",
                            "filter": "new-arrival",
                            "type": 1,
                            "gid": "",
                            "from": 2
                        }
                    },
                    {
                        "key": "",
                        "listType": 2,
                        "width": 501,
                        "height": 318,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/newblouses.png",
                        "url": "/Blouses-c1003/new-arrival/",
                        "nativeConfig": {
                            "nativeUrl": "/api/v1/c1/list/common/1003",
                            "filter": "new-arrival",
                            "type": 1,
                            "gid": "",
                            "from": 2
                        }
                    }
                ]
            },
            {
                "type": 7,
                "columnNum": 0,
                "config": [
                    {
                        "key": "",
                        "listType": 2,
                        "width": 1029,
                        "height": 540,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/salebanner.png",
                        "url": "/Soldes-c1010/",
                        "nativeConfig": {
                            "nativeUrl": "/api/v1/c1/list/common/1010",
                            "filter": "",
                            "type": 1,
                            "gid": "",
                            "from": 2
                        }
                    },
                    {
                        "key": "",
                        "listType": 2,
                        "width": 498,
                        "height": 651,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/saledresses.png",
                        "url": "/Robes-c1011/",
                        "nativeConfig": {
                            "nativeUrl": "/api/v1/c1/list/common/1011",
                            "filter": "",
                            "type": 1,
                            "gid": "",
                            "from": 2
                        }
                    },
                    {
                        "key": "",
                        "listType": 2,
                        "width": 498,
                        "height": 651,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/saleblouses.png",
                        "url": "/Blouses-c1014/",
                        "nativeConfig": {
                            "nativeUrl": "/api/v1/c1/list/common/1014",
                            "filter": "",
                            "type": 1,
                            "gid": "",
                            "from": 2
                        }
                    }
                ]
            },
            {
                "type": 1,
                "columnNum": 0,
                "config": [
                    {
                        "key": "",
                        "listType": 2,
                        "width": 1029,
                        "height": 93,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-11-01/images/banners/shopbystyle/shopbystyle.png",
                        "url": "",
                        "nativeConfig": {
                            "nativeUrl": "",
                            "filter": "",
                            "type": 4,
                            "gid": "",
                            "from": 0
                        }
                    }
                ]
            },{
                "type": 6,
                "columnNum": 0,
                "config": [
                    {
                        "key": "",
                        "listType": 2,
                        "width": 498,
                        "height": 660,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/newdresses.png",
                        "url": "/Robes-c199/new-arrival/",
                        "nativeConfig": {
                            "nativeUrl": "/api/v1/c1/list/common/199",
                            "filter": "new-arrival",
                            "type": 1,
                            "gid": "",
                            "from": 2
                        }
                    },
                    {
                        "key": "",
                        "listType": 2,
                        "width": 501,
                        "height": 318,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/newsweaters.png",
                        "url": "/Pulls-c1002/new-arrival/",
                        "nativeConfig": {
                            "nativeUrl": "/api/v1/c1/list/common/1002",
                            "filter": "new-arrival",
                            "type": 1,
                            "gid": "",
                            "from": 2
                        }
                    },
                    {
                        "key": "",
                        "listType": 2,
                        "width": 501,
                        "height": 318,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/newblouses.png",
                        "url": "/Blouses-c1003/new-arrival/",
                        "nativeConfig": {
                            "nativeUrl": "/api/v1/c1/list/common/1003",
                            "filter": "new-arrival",
                            "type": 1,
                            "gid": "",
                            "from": 2
                        }
                    }
                ]
            },
            {
                "type": 8,
                "columnNum": 0,
                "config": [
                    {
                        "key": "",
                        "listType": 2,
                        "width": 1029,
                        "height": 540,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/stylecasual.png",
                        "url": "",
                        "nativeConfig": {
                            "nativeUrl": "",
                            "filter": "",
                            "type": 4,
                            "gid": "",
                            "from": 0
                        }
                    },
                    {
                        "key": "",
                        "listType": 2,
                        "width": 486,
                        "height": 651,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/stylelegant.png",
                        "url": "",
                        "nativeConfig": {
                            "nativeUrl": "",
                            "filter": "",
                            "type": 4,
                            "gid": "",
                            "from": 0
                        }
                    },
                    {
                        "key": "",
                        "listType": 2,
                        "width": 486,
                        "height": 651,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/stylevacation.png",
                        "url": "",
                        "nativeConfig": {
                            "nativeUrl": "",
                            "filter": "",
                            "type": 4,
                            "gid": "",
                            "from": 0
                        }
                    }
                ]
            },{
                "type": 8,
                "columnNum": 0,
                "config": [
                    {
                        "key": "",
                        "listType": 2,
                        "width": 1029,
                        "height": 540,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/stylecasual.png",
                        "url": "",
                        "nativeConfig": {
                            "nativeUrl": "",
                            "filter": "",
                            "type": 4,
                            "gid": "",
                            "from": 0
                        }
                    },
                    {
                        "key": "",
                        "listType": 2,
                        "width": 486,
                        "height": 651,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/stylelegant.png",
                        "url": "",
                        "nativeConfig": {
                            "nativeUrl": "",
                            "filter": "",
                            "type": 4,
                            "gid": "",
                            "from": 0
                        }
                    },
                    {
                        "key": "",
                        "listType": 2,
                        "width": 486,
                        "height": 651,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/stylevacation.png",
                        "url": "",
                        "nativeConfig": {
                            "nativeUrl": "",
                            "filter": "",
                            "type": 4,
                            "gid": "",
                            "from": 0
                        }
                    }
                ]
            },
            {
                "type": 8,
                "columnNum": 0,
                "config": [
                    {
                        "key": "",
                        "listType": 2,
                        "width": 1029,
                        "height": 540,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/stylecasual.png",
                        "url": "",
                        "nativeConfig": {
                            "nativeUrl": "",
                            "filter": "",
                            "type": 4,
                            "gid": "",
                            "from": 0
                        }
                    },
                    {
                        "key": "",
                        "listType": 2,
                        "width": 486,
                        "height": 651,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/stylelegant.png",
                        "url": "",
                        "nativeConfig": {
                            "nativeUrl": "",
                            "filter": "",
                            "type": 4,
                            "gid": "",
                            "from": 0
                        }
                    },
                    {
                        "key": "",
                        "listType": 2,
                        "width": 486,
                        "height": 651,
                        "showActivityLabel": 0,
                        "image": "https://imgs.veryvoga.com/v5res/veryvoga/2019-10-31/images/banners/AppIndexPic/AppIndexPic/stylevacation.png",
                        "url": "",
                        "nativeConfig": {
                            "nativeUrl": "",
                            "filter": "",
                            "type": 4,
                            "gid": "",
                            "from": 0
                        }
                    }
                ]
            }
        ],
        "activityLabel": {
            "image": "",
            "width": 0,
            "height": 0
        },
        "bestSellCats": [
            {
                "catId": 199,
                "catName": "Robes"
            },
            {
                "catId": 1002,
                "catName": "Pulls"
            },
            {
                "catId": 1003,
                "catName": "Blouses"
            },
            {
                "catId": 84,
                "catName": "Chaussures"
            },
            {
                "catId": 137,
                "catName": "Bijoux"
            },
            {
                "catId": 12,
                "catName": "Sacs"
            }
        ]
    }


            """
        var homeData = Gson().fromJson(json, HomeDataBean::class.java)
        return homeData
    }

    companion object {
        var instance = HomeDataMock()
    }
}