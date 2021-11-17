package com.pavan.quizapp

object Constants{


    const val USER_NAME :String = "user_name"
    const val TOTAL_QUESTIONS :String ="total_questions"
    const val CORRECT_ANSWER :String = "correct_answer"


    fun getQuestions():ArrayList<Questions>{
        val questionSList = ArrayList<Questions>()
        val que1 = Questions(
            1,
            "Who Created Java ?",
             R.drawable.ques1,
            "Dennis Ritchie",
            "Bjarne Stroustrup",
            "James Gosling",
            "Pavan Chaudhari",
            3)

        val que2 = Questions(
            2,
            "What is  the Linux?",
             R.drawable.ques2,
            "Computer",
            "Kernal",
            "Bootloader",
            "None of these above",
            2)
        val que3 = Questions(
            3,
            "Which is the First Programming Language ?",
            R.drawable.ques3,
            "Fortran",
            "C",
            "Basic",
            "Plankalkül",
            4)
        val que4 = Questions(
            4,
            "How Many Library Present in Python?",
            R.drawable.ques4,
            "750",
            "1,35,000",
            "1,00,000",
            "1,37,000",
            4)
        val que5 = Questions(
            5,
            "Which is the Latest version of Android O.S ?",
            R.drawable.ques5,
            "10",
            "11",
            "12",
            "14",
            3
            )
        val que6 = Questions(
            6,
            "which of the following is rdbms ?",
            R.drawable.ques6,
            "DB2",
            "Room",
            "MongoDb",
            "Hbase",
            1
            )
        val que7 = Questions(
            7,
            "Full form of FTP is?",
            R.drawable.ques7,
            "file execution Protocol",
            "file execute permission",
            "File Transfer Protocol",
            "File transfer Permission ",
            3)
        val que8 = Questions(
            8,
            "The Number of layer in OSI model?",
            R.drawable.ques8,
            "5",
            "6",
            "7",
            "8",
            3)
        val que9 = Questions(
            9,
            "What is Scala?",
            R.drawable.ques9,
            "Programming Language",
            "O.S",
            "Protocol",
            "Software",
            1)
        val que10 = Questions(
            10,
            "Which is the best technology ?",
            R.drawable.ques1,
            "Web Development",
            "Android",
            "A.I & M.L",
            "None of these",
            4)


        questionSList.add(que1)
        questionSList.add(que2)
        questionSList.add(que3)
        questionSList.add(que4)
        questionSList.add(que5)
        questionSList.add(que6)
        questionSList.add(que7)
        questionSList.add(que8)
        questionSList.add(que9)
        questionSList.add(que10)
        return questionSList

    }
}