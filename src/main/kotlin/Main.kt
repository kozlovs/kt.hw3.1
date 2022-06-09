fun main() {
    println(agoToText(60*60*11))
}

fun agoToText(secondsAgo: Int): String = when (secondsAgo) {
    in 0..60 -> "был(а) только что"
    in 61..(60 * 60) -> "был(а) ${minutesToText(secondsAgo)} назад"
    in (60 * 60 + 1)..(24 * 60 * 60) -> "был(а) ${hoursToText(secondsAgo)} назад"
    in (24 * 60 * 60 + 1)..(2 * 24 * 60 * 60) -> "был(а) сегодня"
    in (2 * 24 * 60 * 60 + 1)..(3 * 24 * 60 * 60) -> "был(а) вчера"
    else -> "был(а) давно"
}

fun minutesToText(seconds: Int): String {
    val minutes = seconds / 60
    if (minutes in 11..14)
        return "$minutes минут"
    return when(minutes % 10) {
        1 -> "$minutes минуту"
        2, 3, 4 -> "$minutes минуты"
        else -> "$minutes минут"
    }
}

fun hoursToText(seconds: Int): String {
    val hours = seconds / (60 * 60)
    if (hours in 11..14)
        return "$hours часов"
    return when(hours % 10) {
        1 -> "$hours час"
        2, 3, 4 -> "$hours часа"
        else -> "$hours часов"
    }
}