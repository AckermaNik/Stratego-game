# Stratego — Java GUI Game

A two-player, local pass-and-play strategy game inspired by Stratego. The project combines a Swing graphical interface with a Java game model and controller. Each side commands a hidden army, moves pieces across an 8×10 board, and attacks opposing pieces. The implementation also includes optional reduced-army and “No retrieve” variants, a Scout follow-up attack, and a pawn-rescue mechanic.

## Game overview

Blue and Red take alternating turns. The game begins with Blue. At the start of a run, each side's pieces are placed randomly in its deployment area; the opponent's pieces are shown face-down, while the current player's own pieces are visible. The board includes impassable water spaces in the middle. Players select a piece and a destination with the mouse; the interface highlights candidate moves and displays dialogs for special actions or invalid moves.

The standard setup places 30 pieces per side. The optional **Reduced Army** setup places 25. **No retrieve** enables an alternate movement rule implemented in the controller. The armies contain ranked movable pieces, plus immovable Bombs and Flags. Attacks are resolved by rank: the stronger attacker captures the defender, a weaker attacker is captured, and equal ranks remove both. The code also implements special interactions: Dwarf defeats Bomb, and Slayer defeats the rank-10 Dragon. A Scout can move along open rows or columns, and after a move may be offered an additional move when an attack is available.

After eligible advances into the opposing side's territory, a player may be offered the option to rescue a previously captured non-Bomb piece. The player selects a piece from the captured-piece window and places it in an empty square in their starting area. The implementation limits rescues and tracks rescue statistics.

The controller checks for a winner after completed actions. Win conditions include capturing the opposing Flag, eliminating the opposing army, or leaving the other side without movable pieces. Exact behavior follows the rules encoded in this project and may differ from official tournament Stratego rules.

## Workflow

1. `Main` starts the application by constructing `PopUpChoices`.
2. The choices window shows a short entrance graphic and lets players enable the optional rules.
3. Pressing **OK** creates the `Graphics` window and a `Controller`. The controller initializes piece types and counts, randomly populates the board, and starts the turn counter.
4. The Swing board displays the current player's pieces and hides the other side's ranks. A click selects a piece; a second click attempts a move or attack.
5. The view calls controller checks for ownership, legal movement, water/occupied spaces, and attack resolution. The controller updates the board and capture records; the view redraws the board and refreshes the side panel.
6. Special flows may interrupt the ordinary turn: a Scout may get a prompted follow-up attack, or a qualifying advance may offer a rescue. The turn changes after the full action is completed.
7. The side panel shows the active rules, current player, round, attack success percentage, rescue count, and captured pieces. When the controller detects a win, a dialog announces the result and the game exits.

## Project structure

- `src/Main.java` is the application entry point.
- `src/Controller/Controller.java` initializes armies and game state, validates movement, resolves attacks and rescues, tracks turns, and checks end conditions.
- `src/Model/Board/Board.java` stores the 8×10 piece grid and applies movement, attack, and rescue updates.
- `src/Model/Player/Player.java` stores each player's captured pieces and game statistics.
- `src/Model/Turn/Turn.java` tracks alternating turns and rounds.
- `src/Model/Peice/` defines the `Piece` interface, team-color enum, movable/immovable base classes, and concrete unit types. The package spelling `Peice` is used by the existing source.
- `src/View/` contains the Swing board, menu/statistics panel, setup dialog, winner dialog, and Scout/rescue/error prompts.
- `src/bluePieces/`, `src/RedPieces/`, and `src/strategoph.png` provide the piece artwork, hidden-piece tiles, water/board images, and entrance graphic.
- `UMLdiagram2.png` is the project's UML diagram. `.idea/` and the `.iml` files hold IntelliJ project settings.

## Run

The project notes specify Oracle OpenJDK 19. A packaged executable JAR is included; with a compatible JDK and a desktop environment that supports Swing, run it from this directory:

```sh
java -jar Stratego.jar
```

To work from source, open the project in IntelliJ IDEA, select a compatible JDK, and run `Main`. The game requires a graphical desktop; it is not a terminal application.

## Implementation notes

The board state is a `Piece[8][10]` array. The view uses a matching `JButton[8][10]` grid, with each button's text encoding its coordinates; the controller decodes those coordinates to access the model. Piece definitions share behavior through the `Piece` interface and movable/immovable base classes, while concrete classes supply their rank, color, availability, and display identity. Captures, attack outcomes, turn/round counts, and rescue totals are maintained separately from the board so the interface can display statistics.

The project is a GUI-focused implementation with randomized initial placement and hand-coded rules. It does not provide a networked multiplayer mode or a separate army-deployment editor. The included `Stratego.jar` and `out/` contents are built artifacts; source files and image resources are under `src/`.
