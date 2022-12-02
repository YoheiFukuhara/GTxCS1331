import java.util.Scanner;
public class Battleship {

        /**
        * バトルシップのメイン
        */
	public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            char[][] ships1 = inputShips(1, input);
            char[][] ships2 = inputShips(2, input);
            char[][] history1 = initializeShips();
            char[][] history2 = initializeShips();

            System.out.println("Welcome to Battleship!");
            for (int i = 0; ; i++) {
                if (i % 2 == 0) {
                    attackShip(1, 2, input, ships2, history1);
                    if (getHit(history1) >= 5) {
                        System.out.println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!");
                        System.out.print("\nFinal boards:\n\n");
                        printBattleShip(ships1);
                        printBattleShip(history1);
                        break;
                    }
                } else {
                    attackShip(2, 1, input, ships1, history2);
                    if (getHit(history2) >= 5) {
                        System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!");
                        System.out.print("\nFinal boards:\n\n");
                        printBattleShip(history2);
                        printBattleShip(ships2);
                        break;
                    }
                }
            }            
	}

        /**
        * 戦艦位置決定
        * @param player 選択者側の番号
        * @param input Scannerのinput
        * @return 戦艦位置ボード
        */
        private static char[][] inputShips(int player, Scanner input) {
            char[][] ships = initializeShips();
            System.out.println("PLAYER " + player + ", ENTER YOUR SHIPS’ COORDINATES.");

            for (int i = 1; i <= 5; i++) {
                int row = 9;
                int col = 9;
                do {
                    System.out.println("Enter ship " + i + " location:");
                    try {
                        row = input.nextInt();
                        col = input.nextInt();
                    } catch(Exception e) {
                        input.next();
                    }
                    if ( row >= 0 && row < ships.length && col >= 0 && col < ships[0].length) {
                        if ( ships[row][col] == '@' ) {
                            System.out.println("You already have a ship there. Choose different coordinates.");
                        }
                        else {
                            ships[row][col] = '@';
                            break;
                        }
                    } 
                    else {
                        System.out.println("Invalid coordinates. Choose different coordinates.");
                    }                    
                } while(true);
            }
            printBattleShip(ships);
            for (int i = 0; i < 100; i++) {
                System.out.println("");
            }
            return ships;
        }

        /**
        * ボード出力
        * @param player 5*5ボード
        */
	private static void printBattleShip(char[][] player) {
		System.out.print("  ");
		for (int row = -1; row < 5; row++) {
			if (row > -1) {
				System.out.print(row + " ");
			}
			for (int column = 0; column < 5; column++) {
				if (row == -1) {
					System.out.print(column + " ");
				} else {
					System.out.print(player[row][column] + " ");
				}
			}
			System.out.println("");
		}
		System.out.println("");
	}

        /**
        * 戦艦位置ボードの初期化
        * @return 戦艦位置ボード
        */
        private static char[][] initializeShips() {
            char[][] ships = new char[5][5];
            for (int row = 0; row < ships.length; row++) {
                for (int col = 0; col < ships[row].length; col++) {
                    ships[row][col] = '-';
                }
            }            
            return ships;            
        }

        /**
        * 何件撃沈したかを計算
        * @param history 撃沈/失敗履歴ボード
        * @return 撃沈数
        */
        private static int getHit(char[][] history) {
            int hit = 0;
            for (int row = 0; (row < history.length) && (hit != 5); row++) {
                for (int col = 0; (col < history[row].length) && (hit != 5); col++) {
                    //System.out.println("row: " + row + ",col: " + col);
                    if (history[row][col] == 'X') {
                        hit += 1;
                    }
                }
            }
            return hit;
        }

        /**
        * 戦艦への攻撃と撃沈/失敗履歴ボード出力
        * @param attack 攻撃側の番号
        * @param defense 守備側の番号 
        * @param input Scannerのinput
        * @param ships 戦艦位置ボード
        * @param history 撃沈/失敗履歴ボード
        */
        private static void attackShip(int attack, int defense, Scanner input, char[][] ships, char[][] history) {
            while(true) {
                System.out.println("Player " + attack + ", enter hit row/column:");
                int row = 9;
                int col = 9;
                try {
                    row = input.nextInt();
                    col = input.nextInt();
                } catch(Exception e) {
                    input.next();
                }
                if ( row >= 0 && row < ships.length && col >= 0 && col < ships[0].length) {
                    if (history[row][col] == 'X' || history[row][col] == 'O') {
                        System.out.println("You already fired on this spot. Choose different coordinates.");
                    }
                    else if (ships[row][col] == '-') {
                        System.out.println("PLAYER " + attack + " MISSED!");
                        history[row][col] = 'O';
                        ships[row][col] = 'O';
                        break;
                    }
                    else if (ships[row][col] == '@') {
                        System.out.println("PLAYER " + attack + " HIT PLAYER " + defense + "’s SHIP!");
                        history[row][col] = 'X';
                        ships[row][col] = 'X';
                        break;
                    }
                } 
                else {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                }                    
            }
            printBattleShip(history);
        }
}