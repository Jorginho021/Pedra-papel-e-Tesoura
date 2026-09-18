# 🥊 JOKENPÔ DOS PAMPAS

Um aplicativo Android simples e divertido do clássico jogo "Pedra, Papel e Tesoura", personalizado com as cores e a identidade do Rio Grande do Sul.

---

## 🚀 Funcionalidades

- **Jogada Aleatória:** O app sorteia automaticamente entre Pedra, Papel e Tesoura a cada jogada.
- **Contador de Placar:** Registra em tempo real a quantidade de vitórias, derrotas e empates.
- **Visual Tradicionalista:** Fundo em degradê diagonal utilizando as cores da bandeira do Rio Grande do Sul.

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java
- **Interface:** XML (LinearLayout)
- **IDE:** Android Studio

---

## 🎨 Fundo em Degradê (Java)

Para aplicar as cores farroupilhas no fundo da tela sem a necessidade de arquivos XML extras em `drawable`, o degradê foi criado diretamente no código Java através da classe `GradientDrawable`:

```java
View mainLayout = findViewById(R.id.main);
int[] coresGauchas = {
    Color.parseColor("#007A33"), // Verde
    Color.parseColor("#DA1212"), // Vermelho
    Color.parseColor("#FFDA29")  // Amarelo
};
GradientDrawable gradientDrawable = new GradientDrawable(
    GradientDrawable.Orientation.TL_BR, 
    coresGauchas
);
mainLayout.setBackground(gradientDrawable);
