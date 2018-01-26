object RPS {

  def main (args:Array[String]): Unit ={
    playerMove()
  }
  //Takes in the two choices and  decides the winner
  def pickWinner(move1:String, move2:String)=(move1.toLowerCase,move2.toLowerCase) match {
    case (move1,move2)if move1.equals("rock") && move2.equals("scissors") || move1.equals("paper") && move2.equals("rock") || move1.equals("scissors") && move2.equals("paper")=> "Player one wins"
    case (move1,move2)if move2.equals("rock") && move1.equals("scissors") || move2.equals("paper") && move1.equals("rock") || move2.equals("scissors") && move1.equals("paper")=> "Player Two wins"
    case(move1,_)if move1.equals("exit") => "That's it you run away!"
    case (_,_) => "Tie"
  }
  //Used to decide if the AI will have a bias to a certain move or not
  def aiBias(): Boolean ={
    val value = scala.util.Random
    if ((randomNumber+2) == 3) return true
    return false
  }
  def randomNumber(): Int ={
    val value = scala.util.Random
    value.nextInt(2)
  }
  //Used with the AI as it uses numbers to pick a move randomly
  def moves(input:Int) = (input)match{
    case(a) if a == 0 => "paper"
    case(a) if a == 1 => "scissors"
    case(a) if a == 2 => "rock"
  }
  //Use to have AI pick a move if the AI has a bias it will pick a move based on how many times the player has chosen a move
  def aiMove(rockCount:Int, paperCount:Int, scissorsCount:Int, bias:Boolean) = (rockCount, paperCount, scissorsCount, bias) match{
    case(_,_,_,false)=> moves(randomNumber())
    case(rockCount,paperCount,scissorsCount,true) if rockCount > paperCount && rockCount > scissorsCount => moves(0)
    case(rockCount,paperCount,scissorsCount,true) if  paperCount > rockCount && paperCount > scissorsCount => moves(1)
    case(rockCount,paperCount,scissorsCount,true) if scissorsCount > rockCount && scissorsCount > paperCount => moves(2)
    case(_,_,_,true) => moves(randomNumber())
  }
  //
  def playerMove (): Unit ={
    var rockCount = 0
    var paperCount = 0
    var scissorCount =0
    var running = true
    while (running) {
      var input = readInput.toLowerCase

      println(pickWinner(input, aiMove(rockCount, paperCount, scissorCount,aiBias())))
      if (input.equals("rock")) rockCount += 1
      if (input.equals("paper")) paperCount += 1
      if (input.equals("scissors")) scissorCount += 1
      if (input.equals("exit")) running = false
      println(rockCount+" "+paperCount+" "+scissorCount)
    }
  }

  def game(){}


  def readInput: String ={
    scala.io.StdIn.readLine()
  }
}
