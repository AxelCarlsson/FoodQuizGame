package com.example.foodquizgame

object Constants {

    const val USER_NAME: String = "user name"
    const val TOTAL_QUESTIONS: String = "total questions"
    // const val CORRECT_ANSWERS: String = "correct answers"

    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val que1 = Question(1, "What is this food called?",
            "Pizza",
            "Burger",
            "Meatballs",
            "Potato",
            1
        )

        questionsList.add(que1)

        val que2 = Question(
            2, "What is this food called?",

            "Pizza", "Pasta",
            "Burger", "Rice", 3
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
            3, "What is the meal that you usually eat after your food called?",

            "Lunch", "Water",
            "Dinner", "Dessert", 4
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
            4, "What is this food called?",

            "Paella", "Dosa",
            "Pie", "Cake", 2
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
            5, "What is this food called?",

            "Pizza", "Langos",
            "Idli", "Pancake", 3
        )

        questionsList.add(que5)

        // 6
        val que6 = Question(
            6, "What is something Italy is known for?",

            "Pasta", "IKEA",
            "ABBA", "Surströmming", 1
        )

        questionsList.add(que6)

        // 7
        val que7 = Question(
            7, "What is white, small and rhymes with ice?",

            "Pizza", "Burger",
            "Rice", "Calzone", 3
        )

        questionsList.add(que7)

        // 8
        val que8 = Question(
            8, "What is this food called?",

            "Burger", "Pizza",
            "Pie", "Samosa", 4
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
            9, "What is this food called?",

            "Pizza", "Butter-Chicken",
            "Burger", "Pie", 2
        )

        questionsList.add(que9)

        // 10
        val que10 = Question(
            10, "What is this food called?",

            "Biryani", "Pizza",
            "Burger", "Pie", 1
        )

        questionsList.add(que10)

        return questionsList
    }

}

