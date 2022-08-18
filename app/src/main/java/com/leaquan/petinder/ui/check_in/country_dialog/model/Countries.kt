package com.leaquan.petinder.ui.check_in.country_dialog.model

class Countries {

    private val _countries: ArrayList<Country> = ArrayList()
    val countries get() = _countries

    fun getCountry(code: String) : Country?  {

        val countries = _countries.filter {
            it.code == code.uppercase()
        }
        if (countries.isNotEmpty()){
            return countries[0]
        }
        return null
    }

    init {
        _countries.add(
            Country(
                "vn",
                "Vietnam (Việt Nam)",
                84
            )
        )
        _countries.add(
            Country(
                "kr",
                "South Korea (대한민국)",
                82
            )
        )
        _countries.add(
            Country(
                "cn",
                "China (中国)",
                86
            )
        )

        _countries.add(
            Country(
                "in",
                "India (भारत)",
                91
            )
        )
        _countries.add(
            Country(
                "id",
                "Indonesia",
                62
            )
        )
        _countries.add(
            Country(
                "pk",
                "Pakistan (‫پاکستان‬‎)",
                92
            )
        )
        _countries.add(
            Country(
                "th",
                "Thailand (ไทย)",
                66
            )
        )

        _countries.add(
            Country(
                "af",
                "Afghanistan (‫افغانستان‬‎)",
                93
            )
        )
        _countries.add(
            Country(
                "al",
                "Albania (Shqipëri)",
                355
            )
        )
        _countries.add(
            Country(
                "dz",
                "Algeria (‫الجزائر‬‎)",
                213
            )
        )
        _countries.add(
            Country(
                "as",
                "American Samoa",
                1684
            )
        )
        _countries.add(
            Country(
                "ad",
                "Andorra",
                376
            )
        )
        _countries.add(
            Country(
                "ao",
                "Angola",
                244
            )
        )
        _countries.add(
            Country(
                "ai",
                "Anguilla",
                1264
            )
        )
        _countries.add(
            Country(
                "ag",
                "Antigua and Barbuda",
                1268
            )
        )
        _countries.add(
            Country(
                "ar",
                "Argentina",
                54
            )
        )
        _countries.add(
            Country(
                "am",
                "Armenia (Հայաստան)",
                374
            )
        )
        _countries.add(
            Country(
                "aw",
                "Aruba",
                297
            )
        )
        _countries.add(
            Country(
                "au",
                "Australia",
                61
            )
        )
        _countries.add(
            Country(
                "at",
                "Austria (Österreich)",
                43
            )
        )
        _countries.add(
            Country(
                "az",
                "Azerbaijan (Azərbaycan)",
                994
            )
        )
        _countries.add(
            Country(
                "bs",
                "Bahamas",
                1242
            )
        )
        _countries.add(
            Country(
                "bh",
                "Bahrain (‫البحرين‬‎)",
                973
            )
        )
        _countries.add(
            Country(
                "bd",
                "Bangladesh (বাংলাদেশ)",
                880
            )
        )
        _countries.add(
            Country(
                "bb",
                "Barbados",
                1246
            )
        )
        _countries.add(
            Country(
                "by",
                "Belarus (Беларусь)",
                375
            )
        )
        _countries.add(
            Country(
                "be",
                "Belgium (België)",
                32
            )
        )
        _countries.add(
            Country(
                "bz",
                "Belize",
                501
            )
        )
        _countries.add(
            Country(
                "bj",
                "Benin (Bénin)",
                229
            )
        )
        _countries.add(
            Country(
                "bm",
                "Bermuda",
                1441
            )
        )
        _countries.add(
            Country(
                "bt",
                "Bhutan (འབྲུག)",
                975
            )
        )
        _countries.add(
            Country(
                "bo",
                "Bolivia",
                591
            )
        )
        _countries.add(
            Country(
                "ba",
                "Bosnia and Herzegovina (Босна и Херцеговина)",
                387
            )
        )
        _countries.add(
            Country(
                "bw",
                "Botswana",
                267
            )
        )
        _countries.add(
            Country(
                "br",
                "Brazil (Brasil)",
                55
            )
        )
        _countries.add(
            Country(
                "io",
                "British Indian Ocean Territory",
                246
            )
        )
        _countries.add(
            Country(
                "vg",
                "British Virgin Islands",
                1284
            )
        )
        _countries.add(
            Country(
                "bn",
                "Brunei",
                673
            )
        )
        _countries.add(
            Country(
                "bg",
                "Bulgaria (България)",
                359
            )
        )
        _countries.add(
            Country(
                "bf",
                "Burkina Faso",
                226
            )
        )
        _countries.add(
            Country(
                "bi",
                "Burundi (Uburundi)",
                257
            )
        )
        _countries.add(
            Country(
                "kh",
                "Cambodia (កម្ពុជា)",
                855
            )
        )
        _countries.add(
            Country(
                "cm",
                "Cameroon (Cameroun)",
                237
            )
        )
        _countries.add(
            Country(
                "ca",
                "Canada",
                1
            )
        )
        _countries.add(
            Country(
                "cv",
                "Cape Verde (Kabu Verdi)",
                238
            )
        )
        _countries.add(
            Country(
                "bq",
                "Caribbean Netherlands",
                599
            )
        )
        _countries.add(
            Country(
                "ky",
                "Cayman Islands",
                1345
            )
        )
        _countries.add(
            Country(
                "cf",
                "Central African Republic (République centrafricaine)",
                236
            )
        )
        _countries.add(
            Country(
                "td",
                "Chad (Tchad)",
                235
            )
        )
        _countries.add(
            Country(
                "cl",
                "Chile",
                56
            )
        )

        _countries.add(
            Country(
                "cx",
                "Christmas Island",
                61
            )
        )
        _countries.add(
            Country(
                "cc",
                "Cocos (Keeling) Islands",
                61
            )
        )
        _countries.add(
            Country(
                "co",
                "Colombia",
                57
            )
        )
        _countries.add(
            Country(
                "km",
                "Comoros (‫جزر القمر‬‎)",
                269
            )
        )
        _countries.add(
            Country(
                "cd",
                "Congo (DRC) (Jamhuri ya Kidemokrasia ya Kongo)",
                243
            )
        )
        _countries.add(
            Country(
                "cg",
                "Congo (Republic) (Congo-Brazzaville)",
                242
            )
        )
        _countries.add(
            Country(
                "ck",
                "Cook Islands",
                682
            )
        )
        _countries.add(
            Country(
                "cr",
                "Costa Rica",
                506
            )
        )
        _countries.add(
            Country(
                "ci",
                "Côte d’Ivoire",
                225
            )
        )
        _countries.add(
            Country(
                "hr",
                "Croatia (Hrvatska)",
                385
            )
        )
        _countries.add(
            Country(
                "cu",
                "Cuba",
                53
            )
        )
        _countries.add(
            Country(
                "cw",
                "Curaçao",
                599
            )
        )
        _countries.add(
            Country(
                "cy",
                "Cyprus (Κύπρος)",
                357
            )
        )
        _countries.add(
            Country(
                "cz",
                "Czech Republic (Česká republika)",
                420
            )
        )
        _countries.add(
            Country(
                "dk",
                "Denmark (Danmark)",
                45
            )
        )
        _countries.add(
            Country(
                "dj",
                "Djibouti",
                253
            )
        )
        _countries.add(
            Country(
                "dm",
                "Dominica",
                1767
            )
        )
        _countries.add(
            Country(
                "dom",
                "Dominican Republic (República Dominicana)",
                1
            )
        )
        _countries.add(
            Country(
                "ec",
                "Ecuador",
                593
            )
        )
        _countries.add(
            Country(
                "eg",
                "Egypt (‫مصر‬‎)",
                20
            )
        )
        _countries.add(
            Country(
                "sv",
                "El Salvador",
                503
            )
        )
        _countries.add(
            Country(
                "gq",
                "Equatorial Guinea (Guinea Ecuatorial)",
                240
            )
        )
        _countries.add(
            Country(
                "er",
                "Eritrea",
                291
            )
        )
        _countries.add(
            Country(
                "ee",
                "Estonia (Eesti)",
                372
            )
        )
        _countries.add(
            Country(
                "et",
                "Ethiopia",
                251
            )
        )
        _countries.add(
            Country(
                "fk",
                "Falkland Islands (Islas Malvinas)",
                500
            )
        )
        _countries.add(
            Country(
                "fo",
                "Faroe Islands (Føroyar)",
                298
            )
        )
        _countries.add(
            Country(
                "fj",
                "Fiji",
                679
            )
        )
        _countries.add(
            Country(
                "fi",
                "Finland (Suomi)",
                358
            )
        )
        _countries.add(
            Country(
                "fr",
                "France",
                33
            )
        )
        _countries.add(
            Country(
                "gf",
                "French Guiana (Guyane française)",
                594
            )
        )
        _countries.add(
            Country(
                "pf",
                "French Polynesia (Polynésie française)",
                689
            )
        )
        _countries.add(
            Country(
                "ga",
                "Gabon",
                241
            )
        )
        _countries.add(
            Country(
                "gm",
                "Gambia",
                220
            )
        )
        _countries.add(
            Country(
                "ge",
                "Georgia (საქართველო)",
                995
            )
        )
        _countries.add(
            Country(
                "de",
                "Germany (Deutschland)",
                49
            )
        )
        _countries.add(
            Country(
                "gh",
                "Ghana (Gaana)",
                233
            )
        )
        _countries.add(
            Country(
                "gi",
                "Gibraltar",
                350
            )
        )
        _countries.add(
            Country(
                "gr",
                "Greece (Ελλάδα)",
                30
            )
        )
        _countries.add(
            Country(
                "gl",
                "Greenland (Kalaallit Nunaat)",
                299
            )
        )
        _countries.add(
            Country(
                "gd",
                "Grenada",
                1473
            )
        )
        _countries.add(
            Country(
                "gp",
                "Guadeloupe",
                590
            )
        )
        _countries.add(
            Country(
                "gu",
                "Guam",
                1671
            )
        )
        _countries.add(
            Country(
                "gt",
                "Guatemala",
                502
            )
        )
        _countries.add(
            Country(
                "gg",
                "Guernsey",
                44
            )
        )
        _countries.add(
            Country(
                "gn",
                "Guinea (Guinée)",
                224
            )
        )
        _countries.add(
            Country(
                "gw",
                "Guinea-Bissau (Guiné Bissau)",
                245
            )
        )
        _countries.add(
            Country(
                "gy",
                "Guyana",
                592
            )
        )
        _countries.add(
            Country(
                "ht",
                "Haiti",
                509
            )
        )
        _countries.add(
            Country(
                "hn",
                "Honduras",
                504
            )
        )
        _countries.add(
            Country(
                "hk",
                "Hong Kong (香港)",
                852
            )
        )
        _countries.add(
            Country(
                "hu",
                "Hungary (Magyarország)",
                36
            )
        )
        _countries.add(
            Country(
                "is",
                "Iceland (Ísland)",
                354
            )
        )

        _countries.add(
            Country(
                "ir",
                "Iran (‫ایران‬‎)",
                98
            )
        )
        _countries.add(
            Country(
                "iq",
                "Iraq (‫العراق‬‎)",
                964
            )
        )
        _countries.add(
            Country(
                "ie",
                "Ireland",
                353
            )
        )
        _countries.add(
            Country(
                "im",
                "Isle of Man",
                44
            )
        )
        _countries.add(
            Country(
                "il",
                "Israel (‫ישראל‬‎)",
                972
            )
        )
        _countries.add(
            Country(
                "it",
                "Italy (Italia)",
                39
            )
        )
        _countries.add(
            Country(
                "jm",
                "Jamaica",
                1876
            )
        )
        _countries.add(
            Country(
                "jp",
                "Japan (日本)",
                81
            )
        )
        _countries.add(
            Country(
                "je",
                "Jersey",
                44
            )
        )
        _countries.add(
            Country(
                "jo",
                "Jordan (‫الأردن‬‎)",
                962
            )
        )
        _countries.add(
            Country(
                "kz",
                "Kazakhstan (Казахстан)",
                7
            )
        )
        _countries.add(
            Country(
                "ke",
                "Kenya",
                254
            )
        )
        _countries.add(
            Country(
                "ki",
                "Kiribati",
                686
            )
        )
        _countries.add(
            Country(
                "kw",
                "Kuwait (‫الكويت‬‎)",
                965
            )
        )
        _countries.add(
            Country(
                "kg",
                "Kyrgyzstan (Кыргызстан)",
                996
            )
        )
        _countries.add(
            Country(
                "la",
                "Laos (ລາວ)",
                856
            )
        )
        _countries.add(
            Country(
                "lv",
                "Latvia (Latvija)",
                371
            )
        )
        _countries.add(
            Country(
                "lb",
                "Lebanon (‫لبنان‬‎)",
                961
            )
        )
        _countries.add(
            Country(
                "ls",
                "Lesotho",
                266
            )
        )
        _countries.add(
            Country(
                "lr",
                "Liberia",
                231
            )
        )
        _countries.add(
            Country(
                "ly",
                "Libya (‫ليبيا‬‎)",
                218
            )
        )
        _countries.add(
            Country(
                "li",
                "Liechtenstein",
                423
            )
        )
        _countries.add(
            Country(
                "lt",
                "Lithuania (Lietuva)",
                370
            )
        )
        _countries.add(
            Country(
                "lu",
                "Luxembourg",
                352
            )
        )
        _countries.add(
            Country(
                "mo",
                "Macau (澳門)",
                853
            )
        )
        _countries.add(
            Country(
                "mk",
                "Macedonia (FYROM) (Македонија)",
                389
            )
        )
        _countries.add(
            Country(
                "mg",
                "Madagascar (Madagasikara)",
                261
            )
        )
        _countries.add(
            Country(
                "mw",
                "Malawi",
                265
            )
        )
        _countries.add(
            Country(
                "my",
                "Malaysia",
                60
            )
        )
        _countries.add(
            Country(
                "mv",
                "Maldives",
                960
            )
        )
        _countries.add(
            Country(
                "ml",
                "Mali",
                223
            )
        )
        _countries.add(
            Country(
                "mt",
                "Malta",
                356
            )
        )
        _countries.add(
            Country(
                "mh",
                "Marshall Islands",
                692
            )
        )
        _countries.add(
            Country(
                "mq",
                "Martinique",
                596
            )
        )
        _countries.add(
            Country(
                "mr",
                "Mauritania (‫موريتانيا‬‎)",
                222
            )
        )
        _countries.add(
            Country(
                "mu",
                "Mauritius (Moris)",
                230
            )
        )
        _countries.add(
            Country(
                "yt",
                "Mayotte",
                262
            )
        )
        _countries.add(
            Country(
                "mx",
                "Mexico (México)",
                52
            )
        )
        _countries.add(
            Country(
                "fm",
                "Micronesia",
                691
            )
        )
        _countries.add(
            Country(
                "md",
                "Moldova (Republica Moldova)",
                373
            )
        )
        _countries.add(
            Country(
                "mc",
                "Monaco",
                377
            )
        )
        _countries.add(
            Country(
                "mn",
                "Mongolia (Монгол)",
                976
            )
        )
        _countries.add(
            Country(
                "me",
                "Montenegro (Crna Gora)",
                382
            )
        )
        _countries.add(
            Country(
                "ms",
                "Montserrat",
                1664
            )
        )
        _countries.add(
            Country(
                "ma",
                "Morocco (‫المغرب‬‎)",
                212
            )
        )
        _countries.add(
            Country(
                "mz",
                "Mozambique (Moçambique)",
                258
            )
        )
        _countries.add(
            Country(
                "mm",
                "Myanmar (Burma) (မြန်မာ)",
                95
            )
        )
        _countries.add(
            Country(
                "na",
                "Namibia (Namibië)",
                264
            )
        )
        _countries.add(
            Country(
                "nr",
                "Nauru",
                674
            )
        )
        _countries.add(
            Country(
                "np",
                "Nepal (नेपाल)",
                977
            )
        )
        _countries.add(
            Country(
                "nl",
                "Netherlands (Nederland)",
                31
            )
        )
        _countries.add(
            Country(
                "nc",
                "New Caledonia (Nouvelle-Calédonie)",
                687
            )
        )
        _countries.add(
            Country(
                "nz",
                "New Zealand",
                64
            )
        )
        _countries.add(
            Country(
                "ni",
                "Nicaragua",
                505
            )
        )
        _countries.add(
            Country(
                "ne",
                "Niger (Nijar)",
                227
            )
        )
        _countries.add(
            Country(
                "ng",
                "Nigeria",
                234
            )
        )
        _countries.add(
            Country(
                "nu",
                "Niue",
                683
            )
        )
        _countries.add(
            Country(
                "nf",
                "Norfolk Island",
                672
            )
        )
        _countries.add(
            Country(
                "kp",
                "North Korea (조선 민주주의 인민 공화국)",
                850
            )
        )
        _countries.add(
            Country(
                "mp",
                "Northern Mariana Islands",
                1670
            )
        )
        _countries.add(
            Country(
                "no",
                "Norway (Norge)",
                47
            )
        )
        _countries.add(
            Country(
                "om",
                "Oman (‫عُمان‬‎)",
                968
            )
        )

        _countries.add(
            Country(
                "pw",
                "Palau",
                680
            )
        )
        _countries.add(
            Country(
                "ps",
                "Palestine (‫فلسطين‬‎)",
                970
            )
        )
        _countries.add(
            Country(
                "pa",
                "Panama (Panamá)",
                507
            )
        )
        _countries.add(
            Country(
                "pg",
                "Papua New Guinea",
                675
            )
        )
        _countries.add(
            Country(
                "py",
                "Paraguay",
                595
            )
        )
        _countries.add(
            Country(
                "pe",
                "Peru (Perú)",
                51
            )
        )
        _countries.add(
            Country(
                "ph",
                "Philippines",
                63
            )
        )
        _countries.add(
            Country(
                "pl",
                "Poland (Polska)",
                48
            )
        )
        _countries.add(
            Country(
                "pt",
                "Portugal",
                351
            )
        )
        _countries.add(
            Country(
                "pr",
                "Puerto Rico",
                1
            )
        )
        _countries.add(
            Country(
                "qa",
                "Qatar (‫قطر‬‎)",
                974
            )
        )
        _countries.add(
            Country(
                "re",
                "Réunion (La Réunion)",
                262
            )
        )
        _countries.add(
            Country(
                "ro",
                "Romania (România)",
                40
            )
        )
        _countries.add(
            Country(
                "ru",
                "Russia (Россия)",
                7
            )
        )
        _countries.add(
            Country(
                "rw",
                "Rwanda",
                250
            )
        )
        _countries.add(
            Country(
                "bl",
                "Saint Barthélemy (Saint-Barthélemy)",
                590
            )
        )
        _countries.add(
            Country(
                "sh",
                "Saint Helena",
                290
            )
        )
        _countries.add(
            Country(
                "kn",
                "Saint Kitts and Nevis",
                1869
            )
        )
        _countries.add(
            Country(
                "lc",
                "Saint Lucia",
                1758
            )
        )
        _countries.add(
            Country(
                "mf",
                "Saint Martin (Saint-Martin (partie française))",
                590
            )
        )
        _countries.add(
            Country(
                "pm",
                "Saint Pierre and Miquelon (Saint-Pierre-et-Miquelon)",
                508
            )
        )
        _countries.add(
            Country(
                "vc",
                "Saint Vincent and the Grenadines",
                1784
            )
        )
        _countries.add(
            Country(
                "ws",
                "Samoa",
                685
            )
        )
        _countries.add(
            Country(
                "sm",
                "San Marino",
                378
            )
        )
        _countries.add(
            Country(
                "st",
                "São Tomé and Príncipe (São Tomé e Príncipe)",
                239
            )
        )
        _countries.add(
            Country(
                "sa",
                "Saudi Arabia (‫المملكة العربية السعودية‬‎)",
                966
            )
        )
        _countries.add(
            Country(
                "sn",
                "Senegal (Sénégal)",
                221
            )
        )
        _countries.add(
            Country(
                "rs",
                "Serbia (Србија)",
                381
            )
        )
        _countries.add(
            Country(
                "sc",
                "Seychelles",
                248
            )
        )
        _countries.add(
            Country(
                "sl",
                "Sierra Leone",
                232
            )
        )
        _countries.add(
            Country(
                "sg",
                "Singapore",
                65
            )
        )
        _countries.add(
            Country(
                "sx",
                "Sint Maarten",
                1721
            )
        )
        _countries.add(
            Country(
                "sk",
                "Slovakia (Slovensko)",
                421
            )
        )
        _countries.add(
            Country(
                "si",
                "Slovenia (Slovenija)",
                386
            )
        )
        _countries.add(
            Country(
                "sb",
                "Solomon Islands",
                677
            )
        )
        _countries.add(
            Country(
                "so",
                "Somalia (Soomaaliya)",
                252
            )
        )
        _countries.add(
            Country(
                "za",
                "South Africa",
                27
            )
        )

        _countries.add(
            Country(
                "ss",
                "South Sudan (‫جنوب السودان‬‎)",
                211
            )
        )
        _countries.add(
            Country(
                "es",
                "Spain (España)",
                34
            )
        )
        _countries.add(
            Country(
                "lk",
                "Sri Lanka (ශ්‍රී ලංකාව)",
                94
            )
        )
        _countries.add(
            Country(
                "sd",
                "Sudan (‫السودان‬‎)",
                249
            )
        )
        _countries.add(
            Country(
                "sr",
                "Suriname",
                597
            )
        )
        _countries.add(
            Country(
                "sj",
                "Svalbard and Jan Mayen",
                47
            )
        )
        _countries.add(
            Country(
                "sz",
                "Swaziland",
                268
            )
        )
        _countries.add(
            Country(
                "se",
                "Sweden (Sverige)",
                46
            )
        )
        _countries.add(
            Country(
                "ch",
                "Switzerland (Schweiz)",
                41
            )
        )
        _countries.add(
            Country(
                "sy",
                "Syria (‫سوريا‬‎)",
                963
            )
        )
        _countries.add(
            Country(
                "tw",
                "Taiwan (台灣)",
                886
            )
        )
        _countries.add(
            Country(
                "tj",
                "Tajikistan",
                992
            )
        )
        _countries.add(
            Country(
                "tz",
                "Tanzania",
                255
            )
        )
        _countries.add(
            Country(
                "tl",
                "Timor-Leste",
                670
            )
        )
        _countries.add(
            Country(
                "tg",
                "Togo",
                228
            )
        )
        _countries.add(
            Country(
                "tk",
                "Tokelau",
                690
            )
        )
        _countries.add(
            Country(
                "to",
                "Tonga",
                676
            )
        )
        _countries.add(
            Country(
                "tt",
                "Trinidad and Tobago",
                1868
            )
        )
        _countries.add(
            Country(
                "tn",
                "Tunisia (‫تونس‬‎)",
                216
            )
        )
        _countries.add(
            Country(
                "tr",
                "Turkey (Türkiye)",
                90
            )
        )
        _countries.add(
            Country(
                "tm",
                "Turkmenistan",
                993
            )
        )
        _countries.add(
            Country(
                "tc",
                "Turks and Caicos Islands",
                1649
            )
        )
        _countries.add(
            Country(
                "tv",
                "Tuvalu",
                688
            )
        )
        _countries.add(
            Country(
                "vi",
                "U.S. Virgin Islands",
                1340
            )
        )
        _countries.add(
            Country(
                "ug",
                "Uganda",
                256
            )
        )
        _countries.add(
            Country(
                "ua",
                "Ukraine (Україна)",
                380
            )
        )
        _countries.add(
            Country(
                "ae",
                "United Arab Emirates (‫الإمارات العربية المتحدة‬‎)",
                971
            )
        )
        _countries.add(
            Country(
                "gb",
                "United Kingdom",
                44
            )
        )
        _countries.add(
            Country(
                "us",
                "United States",
                1
            )
        )
        _countries.add(
            Country(
                "uy",
                "Uruguay",
                598
            )
        )
        _countries.add(
            Country(
                "uz",
                "Uzbekistan (Oʻzbekiston)",
                998
            )
        )
        _countries.add(
            Country(
                "vu",
                "Vanuatu",
                678
            )
        )
        _countries.add(
            Country(
                "va",
                "Vatican City (Città del Vaticano)",
                39
            )
        )
        _countries.add(
            Country(
                "ve",
                "Venezuela",
                58
            )
        )

        _countries.add(
            Country(
                "wf",
                "Wallis and Futuna",
                681
            )
        )
        _countries.add(
            Country(
                "eh",
                "Western Sahara (‫الصحراء الغربية‬‎)",
                212
            )
        )
        _countries.add(
            Country(
                "ye",
                "Yemen (‫اليمن‬‎)",
                967
            )
        )
        _countries.add(
            Country(
                "zm",
                "Zambia",
                260
            )
        )
        _countries.add(
            Country(
                "zw",
                "Zimbabwe",
                263
            )
        )
        _countries.add(
            Country(
                "ax",
                "Åland Islands",
                358
            )
        )
    }
}