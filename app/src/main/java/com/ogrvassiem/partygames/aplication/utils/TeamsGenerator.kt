package com.ogrvassiem.partygames.aplication.utils

import com.ogrvassiem.partygames.aplication.readModels.TeamInfo
import com.ogrvassiem.partygames.R
import java.util.concurrent.atomic.AtomicInteger
import kotlin.random.Random


class TeamNameGenerator {

    private val icons = listOf(
        R.drawable.img_team_1,
        R.drawable.img_team_1,
        R.drawable.img_team_1,
        R.drawable.img_team_1,
        R.drawable.img_team_1
    )
    private val firstTitles = listOf(
        "Мокрые", "Параноидальные", "Расстроенные", "Обидчивые", "Горячие",
        "Хрустящие", "Зловещие", "Липкие", "Гиперактивные", "Непредсказуемые",
        "Фиолетовые", "Бессонные", "Сверхразумные", "Глючные", "Огуречные",

        "Заспанные", "Гламурные", "Трясущиеся", "Вечно голодные",
        "Слишком быстрые", "Забытые", "Нестабильные", "Электризованные", "Квадратные",
        "Танцующие", "Мультяшные", "Пиксельные"
    )


    private val secondTitles = listOf(
        "кенгуру", "баклажаны", "пельмени", "сирены", "вентиляторы",
        "осьминоги", "гоблины", "утконосы", "единички и нолики", "гномики",
        "пылесосы", "пельмени", "васаби", "тараканчики", "энергетики",

        "макароны", "лопатки", "бабушки", "телепузики", "бананы",
        "молекулы", "зебры", "панды", "неоновые тапочки",
        "ужи", "ламы", "дятлы в шлемах"
    )


    private val endings = listOf(
        "Никогда не сдаются (и не моются)",
        "Где мы? Кто мы? Почему?",
        "Нас не остановить, даже если очень попросить",
        "В бой! За холодильник!",
        "Пельмени будут отомщены!",
        "Мы не проиграли, мы просто стратегически отступили",
        "На нас ещё можно поставить!",
        "Мы вызываем Чебурашку!",
        "Техническое поражение — это тоже победа!",
        "Нас боится даже ваша бабушка!",
        "Сегодня не наш день... а чей?",
        "Мы в душе чемпионы!",
        "Наша стратегия: хаос и случайность",
        "Мы готовы, но не уверены!",
        "Наш девиз: \"Кто здесь главный?\"",

        "Если что – мы были не в курсе!",
        "План: победить! Реальность: смех и боль.",
        "В конце концов, важен не результат, а то, как мы ели пиццу!",
        "Случайность? Не думаю.",
        "Ждём, когда нас запишут в учебники истории!",
        "Мама сказала, мы особенные!",
        "Если не победим, хотя бы красиво проиграем!",
        "Возможно, нас взломали.",
        "Сила духа, крепость нервов и немного чая.",
        "Наши талисманы – два тапка и немного надежды!",
        "Мы пытались! Правда.",
        "Серьёзность? Нет, не слышали.",
        "Лучшая команда по мнению нашей бабушки!",
        "Кто успел, тот и чемпион!"
    )

    fun generateTeam(): TeamInfo {
        return TeamInfo(
            iconRes = icons.random(),
            firstTitle = firstTitles.random(),
            secondTitle = secondTitles.random(),
            ending = endings.random(),
            id = IDGenerator.generateId()
        )
    }

}

object IDGenerator {
    private val counter = AtomicInteger(1)

    fun generateId(): Int {
        return counter.getAndIncrement()
    }
}