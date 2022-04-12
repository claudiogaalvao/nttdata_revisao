package com.claudiogalvaodev.nttdatarevisao.model

data class Dog(
    val id: Int,
    val name: String,
    val bred_for: String,
    val breed_group: String,
    val life_span: String,
    val origin: String,
    val country_code: String?,
    val reference_image_id: String,
    val temperament: String,
    val image: Image,
    val height: Measure,
    val weight: Measure
)

fun mockDogs() = listOf(
    Dog(
        id = 1,
        name = "Affenpinscher",
        bred_for = "Small rodent hunting, lapdog",
        breed_group = "Toy",
        life_span = "10 - 12 years",
        temperament = "Stubborn, Curious, Playful, Adventurous, Active, Fun-loving",
        origin = "Germany, France",
        country_code = null,
        reference_image_id = "BJa4kxc4X",
        image = Image(
            id = "BJa4kxc4X",
            width = 1600,
            height = 1199,
            url = "https://cdn2.thedogapi.com/images/BJa4kxc4X.jpg"
        ),
        weight = Measure(
            imperial = "6 - 13",
            metric = "3 - 6"
        ),
        height = Measure(
            imperial = "9 - 11.5",
            metric = "23 - 29"
        ),
    ),
    Dog(
        id = 2,
        name = "Afghan Hound",
        bred_for = "Coursing and hunting",
        breed_group = "Hound",
        life_span = "10 - 13 years",
        temperament = "Aloof, Clownish, Dignified, Independent, Happy",
        origin = "Afghanistan, Iran, Pakistan",
        country_code = "AG",
        reference_image_id = "hMyT4CDXR",
        image = Image(
            id = "hMyT4CDXR",
            width = 606,
            height = 380,
            url = "https://cdn2.thedogapi.com/images/hMyT4CDXR.jpg"
        ),
        weight = Measure(
            imperial = "50 - 60",
            metric = "23 - 27"
        ),
        height = Measure(
            imperial = "25 - 27",
            metric = "64 - 69"
        ),
    ),
    Dog(
        id = 3,
        name = "African Hunting Dog",
        bred_for = "A wild pack animal",
        breed_group = "Toy",
        life_span = "11 years",
        temperament = "Wild, Hardworking, Dutiful",
        origin = "",
        country_code = null,
        reference_image_id = "rkiByec47",
        image = Image(
            id = "rkiByec47",
            width = 500,
            height = 335,
            url = "https://cdn2.thedogapi.com/images/rkiByec47.jpg"
        ),
        weight = Measure(
            imperial = "44 - 66",
            metric = "20 - 30"
        ),
        height = Measure(
            imperial = "30",
            metric = "76"
        ),
    ),
    Dog(
        id = 4,
        name = "Airedale Terrier",
        bred_for = "Badger, otter hunting",
        breed_group = "Terrier",
        life_span = "10 - 13 years",
        temperament = "Outgoing, Friendly, Alert, Confident, Intelligent, Courageous",
        origin = "United Kingdom, England",
        country_code = null,
        reference_image_id = "1-7cgoZSh",
        image = Image(
            id = "1-7cgoZSh",
            width = 645,
            height = 430,
            url = "https://cdn2.thedogapi.com/images/1-7cgoZSh.jpg"
        ),
        weight = Measure(
            imperial = "40 - 65",
            metric = "18 - 29"
        ),
        height = Measure(
            imperial = "21 - 23",
            metric = "53 - 58"
        ),
    ),
    Dog(
        id = 5,
        name = "Akbash Dog",
        bred_for = "Sheep guarding",
        breed_group = "Working",
        life_span = "10 - 12 years",
        temperament = "Loyal, Independent, Intelligent, Brave",
        origin = "Germany, France",
        country_code = "",
        reference_image_id = "26pHT3Qk7",
        image = Image(
            id = "26pHT3Qk7",
            width = 600,
            height = 471,
            url = "https://cdn2.thedogapi.com/images/26pHT3Qk7.jpg"
        ),
        weight = Measure(
            imperial = "90 - 120",
            metric = "41 - 54"
        ),
        height = Measure(
            imperial = "28 - 34",
            metric = "71 - 86"
        ),
    )
)