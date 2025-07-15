package org.flishl1.subtrack.enums.bot

enum class CommandAnswer(
    var value: String
) {
    START_SUCCESSFUL("""
        👋 Привет! Я помогу тебе контролировать подписки.  
           Сейчас я авторизирую тебя 
    """),
    START_EXIST("""
        👋 Привет {0}! Я помогу тебе контролировать подписки.  

        📌 *Твоя статистика:*  
        • Активных подписок: {1}  
        • Ближайший платеж: {2}  
    """)
}