package br.ulbra.pedrapapeltisoura;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int vitorias = 0;
    private int derrotas = 0;
    private int empates = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Aplica o degradê do Rio Grande do Sul via código Java no fundo da tela
        View mainLayout = findViewById(R.id.main);
        int[] coresGauchas = {
                Color.parseColor("#007A33"), // Verde
                Color.parseColor("#DA1212"), // Vermelho
                Color.parseColor("#FFDA29")  // Amarelo
        };
        GradientDrawable gradientDrawable = new GradientDrawable(
                GradientDrawable.Orientation.TL_BR, // Diagonal: Top-Left to Bottom-Right
                coresGauchas
        );
        mainLayout.setBackground(gradientDrawable);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void selecionarPedra(View view) {
        opcaoSelecionada("pedra");
    }

    public void selecionarPapel(View view) {
        opcaoSelecionada("papel");
    }

    public void selecionarTesoura(View view) {
        opcaoSelecionada("tesoura");
    }

    private void opcaoSelecionada(String escolhaUsuario) {
        ImageView imageApp = findViewById(R.id.imageResultado);
        TextView textResultado = findViewById(R.id.textResultado);

        String[] opcoes = {"pedra", "papel", "tesoura"};
        int numeroAleatorio = new Random().nextInt(3);
        String escolhaApp = opcoes[numeroAleatorio];

        switch (escolhaApp) {
            case "pedra":
                imageApp.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageApp.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageApp.setImageResource(R.drawable.tesoura);
                break;
        }

        verificarGanhador(escolhaUsuario, escolhaApp, textResultado);
    }

    private void verificarGanhador(String escolhaUsuario, String escolhaApp, TextView textResultado) {
        if (
                (escolhaApp.equals("tesoura") && escolhaUsuario.equals("papel")) ||
                        (escolhaApp.equals("papel") && escolhaUsuario.equals("pedra")) ||
                        (escolhaApp.equals("pedra") && escolhaUsuario.equals("tesoura"))
        ) {
            derrotas++;
            textResultado.setText("Você perdeu! :(");
        } else if (
                (escolhaUsuario.equals("tesoura") && escolhaApp.equals("papel")) ||
                        (escolhaUsuario.equals("papel") && escolhaApp.equals("pedra")) ||
                        (escolhaUsuario.equals("pedra") && escolhaApp.equals("tesoura"))
        ) {
            vitorias++;
            textResultado.setText("Você ganhou! :)");
        } else {
            empates++;
            textResultado.setText("Empatamos! ;)");
        }

        TextView textPlacar = findViewById(R.id.textPlacar);
        textPlacar.setText("Vitórias: " + vitorias + " | Derrotas: " + derrotas + " | Empates: " + empates);
    }
}
