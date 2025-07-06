package org.flishl1.subtrack.enums.bot

enum class CommandAnswer(
    var value: String
) {
    START_SUCCESSFUL("Вы теперь можете пользоваться ботом"),
    START_EXIST("Вы и так есть в боте, не лезте")
}