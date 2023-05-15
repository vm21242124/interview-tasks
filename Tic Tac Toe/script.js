// Game variables
let board = ["", "", "", "", "", "", "", "", ""];
let currentPlayer = "X";
let gameStatus = "";

// Select all the cells
const cells = document.querySelectorAll(".cell");
const turns = document.querySelector(".turns");
const resetbtn=document.querySelector(".resetbtn")
const winsound=document.querySelector("#winAudio")
const turnSound=document.querySelector("#turnsound")
const O_tone=document.querySelector("#O_tone")
// Function to check if there's a winner
function checkWinner() {
  const winningCombinations = [
    [0, 1, 2],
    [3, 4, 5],
    [6, 7, 8],
    [0, 3, 6],
    [1, 4, 7],
    [2, 5, 8],
    [0, 4, 8],
    [2, 4, 6],
  ];

  for (let i = 0; i < winningCombinations.length; i++) {
    const [a, b, c] = winningCombinations[i];
    if (board[a] && board[a] === board[b] && board[a] === board[c]) {
      return board[a];
    }
  }

  if (board.includes("")) {
    return "";
  } else {
    return "Tie";
  }
}

// Function to render the board
function render() {
  cells.forEach((cell, index) => {
    cell.textContent = board[index];
  });
}

// Function to handle a cell click
function handleCellClick(e) {
  const cell = e.target;
  const index = cell.id;

  if (board[index] === "" && gameStatus === "") {
    board[index] = currentPlayer;
    render();
    const winner = checkWinner();
    if (winner !== "") {
      gameStatus = winner + " wins!";
      if (winner === "Tie") {
        turns.textContent =
          "Well Played Both !! Its Tie !! Challannge In Next Game";
          winsound.play()
      } else {
        turns.textContent = "Congratulations "+winner + " wins! 🎉🎊";
        winsound.play()
      }
    } else {
        if(currentPlayer==="X"){
            currentPlayer="O";
            turnSound.play()
        }else{
            currentPlayer="X"
            O_tone.play()
        }
     
      turns.textContent = currentPlayer + " Turn Now 🤔";
    }
  }
}

function resetGame() {
    winsound.pause()
  board = ["", "", "", "", "", "", "", "", ""];
  currentPlayer = "X";
  gameStatus = "";
  turns.textContent = "Lets Start X Turn First";
  render();

}
// Add event listener to each cell
cells.forEach((cell) => {
  cell.addEventListener("click", handleCellClick);
});
resetbtn.addEventListener("click",resetGame)
render();
