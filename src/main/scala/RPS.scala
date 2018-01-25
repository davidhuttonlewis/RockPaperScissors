object RPS {

  def main (args:Array[String]): Unit ={



playerMove()


  }

  def pickWinner(move1:String, move2:String)=(move1,move2) match {
    case (_,_)if move1.equalsIgnoreCase("rock") && move2.equalsIgnoreCase("scissors")=> "Player one wins with rock"
    case (_,_)if move1.equalsIgnoreCase("paper") && move2.equalsIgnoreCase("rock")=> "Player one wins with paper"
    case (_,_)if move1.equalsIgnoreCase("scissors") && move2.equalsIgnoreCase("paper")=> "Player one wins with scissors"
    case (_,_)if move2.equalsIgnoreCase("rock") && move1.equalsIgnoreCase("scissors")=> "Player two wins with rock"
    case (_,_)if move2.equalsIgnoreCase("paper") && move1.equalsIgnoreCase("rock")=> "Player two wins with paper"
    case (_,_)if move2.equalsIgnoreCase("scissors") && move1.equalsIgnoreCase("paper")=> "Player two wins with scissors"
    case (_,_) => "Tie"
  }
  def aiMove(rockCount:Int, paperCount:Int, scissorsCount:Int) = (rockCount, paperCount, scissorsCount) match{
    case(a,b,c) if a > b && a > c => "paper"
    case(a,b,c) if  b > a && b > c => "scissors"
    case(a,b,c) if c > a && c > b => "rock"
    case(a,b,c)if a == b && a == c => "scissors"
  }
  def playerMove () ={

    var rockCount = 0
    var paperCount = 0
    var scissorCount =0
   var running = true
    while (running) {
      var input = readInput
      println(pickWinner(input, aiMove(rockCount, paperCount, scissorCount)))
      if (input.equalsIgnoreCase("rock")) rockCount += 1
      if (input.equalsIgnoreCase("paper")) paperCount += 1
      if (input.equalsIgnoreCase("scissors")) scissorCount += 1
      if (input.equalsIgnoreCase("exit")) running = false
      println(rockCount+" "+paperCount+" "+scissorCount)
    }
  }

  def readInput: String ={
    scala.io.StdIn.readLine()
  }
}
