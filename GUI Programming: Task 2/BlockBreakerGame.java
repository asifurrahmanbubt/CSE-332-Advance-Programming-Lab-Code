import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BlockBreakerGame extends JPanel implements ActionListener {
    private int ballX = 160, ballY = 300; // Initial ball position
    private int ballDiameter = 20;
    private int ballDeltaX = 2, ballDeltaY = -3; // Ball movement direction

    private int paddleX = 150; // Paddle position
    private final int PADDLE_WIDTH = 80, PADDLE_HEIGHT = 10;

    private final int ROWS = 5, COLS = 10; // Brick grid size
    private final int BRICK_WIDTH = 50, BRICK_HEIGHT = 20;
    private boolean[][] bricks = new boolean[ROWS][COLS]; // Bricks grid

    private Timer timer;
    private boolean gameRunning = true;

    public BlockBreakerGame() {
        timer = new Timer(10, this); // Timer to refresh game screen
        timer.start();

        initializeBricks();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT && paddleX > 0) {
                    paddleX -= 15;
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && paddleX < getWidth() - PADDLE_WIDTH) {
                    paddleX += 15;
                } else if (!gameRunning && e.getKeyCode() == KeyEvent.VK_R) {
                    restartGame();
                }
            }
        });
        setFocusable(true);
        requestFocusInWindow();
    }

    private void initializeBricks() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                bricks[i][j] = true;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw ball
        g.setColor(Color.RED);
        g.fillOval(ballX, ballY, ballDiameter, ballDiameter);

        // Draw paddle
        g.setColor(Color.BLUE);
        g.fillRect(paddleX, getHeight() - PADDLE_HEIGHT - 30, PADDLE_WIDTH, PADDLE_HEIGHT);

        // Draw bricks
        g.setColor(Color.GREEN);
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (bricks[i][j]) {
                    g.fillRect(j * BRICK_WIDTH + 10, i * BRICK_HEIGHT + 10, BRICK_WIDTH - 5, BRICK_HEIGHT - 5);
                }
            }
        }

        // Game Over and Win text
        if (!gameRunning) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 24));
            String message = checkWinCondition() ? "You Win!" : "Game Over!";
            g.drawString(message, getWidth() / 2 - 80, getHeight() / 2);

            g.setFont(new Font("Arial", Font.PLAIN, 18));
            g.drawString("Press 'R' to Restart", getWidth() / 2 - 100, getHeight() / 2 + 30);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameRunning) {
            // Move ball
            ballX += ballDeltaX;
            ballY += ballDeltaY;

            // Ball collision with walls
            if (ballX <= 0 || ballX >= getWidth() - ballDiameter) {
                ballDeltaX = -ballDeltaX;
            }
            if (ballY <= 0) {
                ballDeltaY = -ballDeltaY;
            }
            if (ballY >= getHeight() - ballDiameter) {
                gameRunning = false; // Ball hits bottom wall
            }

            // Ball collision with paddle
            if (new Rectangle(ballX, ballY, ballDiameter, ballDiameter)
                    .intersects(new Rectangle(paddleX, getHeight() - PADDLE_HEIGHT - 30, PADDLE_WIDTH, PADDLE_HEIGHT))) {
                ballDeltaY = -ballDeltaY;
            }

            // Ball collision with bricks
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    if (bricks[i][j]) {
                        int brickX = j * BRICK_WIDTH + 10;
                        int brickY = i * BRICK_HEIGHT + 10;
                        Rectangle brickRect = new Rectangle(brickX, brickY, BRICK_WIDTH - 5, BRICK_HEIGHT - 5);
                        Rectangle ballRect = new Rectangle(ballX, ballY, ballDiameter, ballDiameter);

                        if (ballRect.intersects(brickRect)) {
                            bricks[i][j] = false;
                            ballDeltaY = -ballDeltaY;
                        }
                    }
                }
            }
            repaint();
        }
    }

    // Check if all bricks are broken
    private boolean checkWinCondition() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (bricks[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // Restart the game
    private void restartGame() {
        ballX = 160;
        ballY = 300;
        ballDeltaX = 2;
        ballDeltaY = -3;
        paddleX = 150;
        gameRunning = true;
        initializeBricks();
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Block Breaker Game");
        BlockBreakerGame game = new BlockBreakerGame();
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
        frame.setVisible(true);
    }
}
