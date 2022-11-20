import java.util.ArrayList

fun main(){

    var AppControl : Boolean = false
    var signUpControl : Boolean = false
    var DataControl : Boolean = false
    var SureControl : Boolean = false
    var MenuControl : Boolean = false

    var UsernameArchive : ArrayList<String> = ArrayList()
    var PasswordArchive : ArrayList<String> = ArrayList()
    var UsernameTest : String = ""
    var PasswordTest : String = ""
    var singUp : String = ""

    var Menu : ArrayList<String> = ArrayList()
    var Questions : ArrayList<String> = ArrayList()
    var Answers : ArrayList<String> = ArrayList()
    var UserAnswers : ArrayList<String> = ArrayList()
    var RightAnswers : ArrayList<String> = ArrayList()
    var UserRightAnswers : Int = 0

    while (AppControl == false) {

        UsernameArchive.add("ADMIN")
        PasswordArchive.add("ADMIN")

        while (signUpControl == false) {

            println("----------LOGIN MENU----------")
            print("Welcome, are you already registered? Choose between YES or NO: ")
            singUp = readLine()!!.toString()

            if (singUp.equals("YES", ignoreCase = true)) {

                while (DataControl == false) {

                    print("Enter your Username: ")
                    UsernameTest = readLine()!!.toString()

                    print("Enter your Password: ")
                    PasswordTest = readLine()!!.toString()

                    for (i in 0 until UsernameArchive.size) {

                        if ((UsernameTest.equals(UsernameArchive.get(i))) && (PasswordTest.equals(PasswordArchive.get(i)))) {
                            println("Valid Username and Password")
                            UsernameTest = UsernameArchive.get(i)
                            PasswordTest = PasswordArchive.get(i)
                            signUpControl = true
                            DataControl = true
                            break
                        } else {
                            println("Invalid Username or Password")
                        }

                    }

                }

            }
            if (singUp.equals("NO", ignoreCase = true)) {

                print("Enter the Username: ")
                UsernameTest = readLine()!!.toString()

                print("Enter the Password: ")
                PasswordTest = readLine()!!.toString()

                if ( !(UsernameTest.equals("ADMIN", ignoreCase = true)) && !(PasswordTest.equals("ADMIN", ignoreCase = true)) ) {

                    while (SureControl == false) {

                        print("Are u sure? Choose between YES or NO: ")
                        var Sure: String = readLine()!!.toString()

                        if (Sure.equals("YES", ignoreCase = true)) {
                            UsernameArchive.add(UsernameTest)
                            PasswordArchive.add(PasswordTest)
                            println("Registration successfully!!")
                            SureControl = true
                            signUpControl = true
                        } else {
                            SureControl = true
                        }

                    }

                }

            }

        }
        signUpControl = false
        DataControl = false
        SureControl = false

        var Choose : String = ""
        var TestAnswer : Int = 0
        var CorrectAnswer : Int = 0

        if ( !(UsernameTest.equals("ADMIN")) && !(PasswordTest.equals("ADMIN")) ){

            println("----------USER MENU----------")

            Menu.add("START")
            Menu.add("EXIT")

            while (MenuControl == false) {

                print("Choose one of this options --> ")
                print(Menu)
                print(": ")
                Choose = readLine()!!.toString()

                if (Choose.equals("START", ignoreCase = true)){

                    for (i in 0 until Questions.size) {

                        print("Question number ${i}: ")
                        println(Questions.get(i))

                        if (i == 0) {
                            print("1) ")
                            println(Answers.get(i))
                            print("2) ")
                            println(Answers.get(i + 1))
                            print("3) ")
                            println(Answers.get(i + 2))
                            println("")
                        }
                        else{
                            print("1) ")
                            println(Answers.get((i*3)))
                            print("2) ")
                            println(Answers.get((i*3)+1))
                            print("3) ")
                            println(Answers.get((i*3)+2))
                            println("")
                        }

                        print("What is your answer?: ")
                        TestAnswer = readLine()!!.toInt()
                        TestAnswer -= 1

                        if (i != 0){
                            UserAnswers.add(Answers.get((i*3)+TestAnswer))
                        }
                        else{
                            UserAnswers.add(Answers.get(TestAnswer))
                        }

                    }

                    for (i in 0 until RightAnswers.size){
                        if (UserAnswers.get(i).equals(RightAnswers.get(i))){
                            UserRightAnswers++
                        }
                        else{
                            continue
                        }
                    }

                    println("----------TEST COMPLETED----------")
                    print("Your score is: ")
                    println("${UserRightAnswers}/${RightAnswers.size} ")

                    MenuControl = true

                }
                if (Choose.equals("EXIT", ignoreCase = true)){

                    print("Are you sure you want exit? [YES][NO]: ")
                    var ExitAnswer : String = readLine()!!.toString()

                    if (ExitAnswer.equals("YES", ignoreCase = true)){
                        MenuControl = true
                    }
                    else{
                        continue
                    }

                }

            }

        }
        if ( (UsernameTest.equals("ADMIN")) && (PasswordTest.equals("ADMIN")) ){

            println("----------ADMIN MENU----------")

            Menu.add("ADD")
            Menu.add("REMOVE")
            Menu.add("VIEW")
            Menu.add("EXIT")

            while (MenuControl == false) {
                print("Choose one of this options --> ")
                print(Menu)
                print(": ")
                Choose = readLine()!!.toString()

                if (Choose.equals("ADD", ignoreCase = true)) {

                    print("What question do you wanna add?: ")
                    var QuestionAdd: String = readLine()!!.toString()
                    Questions.add(QuestionAdd)

                    println("What are the answers? (You must enter 3 answers!!)")
                    print("Answer number one: ")
                    var AnswersAdd : String = readLine()!!.toString()
                    Answers.add(AnswersAdd)

                    print("Answer number two: ")
                    AnswersAdd = readLine()!!.toString()
                    Answers.add(AnswersAdd)

                    print("Answer number three: ")
                    AnswersAdd = readLine()!!.toString()
                    Answers.add(AnswersAdd)

                    print("Which of these answers is the correct one?: ")
                    CorrectAnswer = readLine()!!.toInt()
                    CorrectAnswer -= 1

                    if (Questions.size == 1){
                        RightAnswers.add(Answers.get(CorrectAnswer))
                    }
                    else{
                        RightAnswers.add(Answers.get(((Questions.size - 1)*3)+CorrectAnswer))
                    }
                    CorrectAnswer = 0
                    println("Add completed!!")

                }
                if (Choose.equals("REMOVE", ignoreCase = true)){

                    println(Questions)
                    print("Which question you want to remove (use numbers!!): ")
                    var Remover : Int = readLine()!!.toInt()
                    Remover = Remover - 1

                    if (Remover < Questions.size) {

                        Questions.removeAt(Remover)

                        if (Remover != 0) {
                            Answers.removeAt((Remover * 3) +2)
                            Answers.removeAt((Remover * 3) + 1)
                            Answers.removeAt(Remover * 3)
                        } else {
                            Answers.removeAt(2)
                            Answers.removeAt(1)
                            Answers.removeAt(0)
                        }

                    }
                    else{
                        println("You must enter a number consistent with the questions!!")
                    }

                }
                if (Choose.equals("VIEW", ignoreCase = true)){

                    for (i in 0 until Questions.size){

                        print("Question number ${(i)}: ")
                        println(Questions.get(i))

                        if (i == 0) {
                            print("1) ")
                            println(Answers.get(i))
                            print("2) ")
                            println(Answers.get(i + 1))
                            print("3) ")
                            println(Answers.get(i + 2))
                            println("")
                        }
                        else{
                            print("1) ")
                            println(Answers.get((i*3)))
                            print("2) ")
                            println(Answers.get((i*3)+1))
                            print("3) ")
                            println(Answers.get((i*3)+2))
                            println("")
                        }

                    }

                    if(Questions.size == 0){
                        println("There are no questions entered!!")
                    }

                }
                if (Choose.equals("EXIT", ignoreCase = true)){

                    print("Are you sure you want exit? [YES][NO]: ")
                    var ExitAnswer : String = readLine()!!.toString()

                    if (ExitAnswer.equals("YES", ignoreCase = true)){
                        MenuControl = true
                    }
                    else{
                        continue
                    }

                }

            }

        }

        MenuControl = false
        Menu.clear()

    }

}
