# Assignment 1 — Hello World Opcional (System Info App)

**Curso:** Licenciatura em Engenharia Informatica e Multimedia
**Unidade Curricular:** Desenvolvimento de Aplicacoes Moveis (DAM)
**Aluno:** Sofia — dam_a51694
**Data:** Fevereiro/Marco 2026
**Repositorio:** https://github.com/sofiamsalgado/HelloWorldOptional

---

## 1. Introducao

O objetivo desta tarefa foi criar uma aplicacao Android que mostra informacao sobre o dispositivo atual usando o objeto `android.os.Build`. A aplicacao exibe os dados num campo de texto multi-linha.

> As secoes 7 a 11 nao se aplicam a esta tarefa pois e marcada como **AC YES, AI NO** — essas secoes sao reservadas exclusivamente para tarefas com uso de IA permitido.

---

## 2. Descricao do Sistema

Aplicacao com uma unica Activity que, ao ser iniciada, preenche automaticamente um `EditText` com informacao do sistema: fabricante, modelo, marca, tipo de build, utilizador, versao base, numero incremental, SDK, versao Android visivel e identificador do display.

---

## 3. Arquitetura e Design

```
HelloWorldOptional/
├── app/src/main/
│   ├── java/dam_a51694/helloworldoptional/
│   │   └── MainActivity.kt
│   └── res/
│       └── layout/activity_main.xml
└── AndroidManifest.xml
```

- Layout simples com um `EditText` multi-linha dentro de um `ConstraintLayout`.
- O `EditText` ocupa o ecra e mostra toda a informacao do sistema de forma legivel.

---

## 4. Implementacao

### Passo a passo

1. Criar novo projeto Android Studio: `HelloWorldOptional`, package `dam_a51694.helloworldoptional`.
2. No `activity_main.xml`, adicionar um `EditText` pelo **Palette** no lado esquerdo do editor:
   - Ir a categoria `Text` no Palette, clicar em `Plain Text` e arrastar para a area de design.
   - Definir as constraints no painel **Attributes** para posicionar o elemento no ecra.
   - Configurar `android:layout_width="match_parent"` e `android:padding="16dp"` nos atributos.
3. No `MainActivity.kt`, usar `android.os.Build` para recolher informacao do dispositivo e mostrar no `EditText`.

### Layout (activity_main.xml)

```xml
<EditText
    android:id="@+id/tvInfo"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:ems="10"
    android:padding="16dp"
    android:text="Device info"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent"
    app:layout_constraintVertical_bias="0.231" />
```

### Logica (MainActivity.kt)

```kotlin
package dam_a51694.helloworldoptional

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvInfo = findViewById<TextView>(R.id.tvInfo) // encontra o TextView do layout pelo id

        // criar um texto com varias linhas com informacao do dispositivo
        val info = """
            Manufacturer: ${Build.MANUFACTURER}
            Model: ${Build.MODEL}
            Brand: ${Build.BRAND}
            Type: ${Build.TYPE}
            User: ${Build.USER}
            Base: ${Build.VERSION_CODES.BASE}
            Incremental: ${Build.VERSION.INCREMENTAL}
            SDK: ${Build.VERSION.SDK_INT}
            Version Code: ${Build.VERSION.RELEASE}
            Display: ${Build.DISPLAY}
        """.trimIndent()

        // mostrar o texto no EditText
        tvInfo.text = info
    }
}
```

Campos mostrados e o que significam:
- `Build.MANUFACTURER` — fabricante do dispositivo (ex: Google, Samsung)
- `Build.MODEL` — modelo do dispositivo (ex: Pixel 9 Pro)
- `Build.BRAND` — marca comercial (ex: google)
- `Build.TYPE` — tipo de build (ex: user, userdebug)
- `Build.USER` — utilizador que fez a build
- `Build.VERSION_CODES.BASE` — versao base do Android (sempre 1)
- `Build.VERSION.INCREMENTAL` — numero interno da build
- `Build.VERSION.SDK_INT` — nivel do SDK (ex: 34 para Android 14)
- `Build.VERSION.RELEASE` — versao Android visivel (ex: 14)
- `Build.DISPLAY` — identificador completo da build

A string multilinhas usa `trimIndent()` para remover os espacos de indentacao em excesso, tornando o codigo mais legivel sem afectar o texto mostrado.

---

## 5. Testes e Validacao

- Testado no emulador Pixel 9 Pro — mostra os dados do dispositivo virtual.
- Testado no dispositivo fisico — mostra os dados reais do telemovel.
- Verificado que todos os campos do `Build` mostram valores corretos e legiveis.

---

## 6. Instrucoes de Uso

1. Abrir o projeto `HelloWorldOptional` no Android Studio.
2. Correr no emulador ou dispositivo fisico.
3. A informacao do sistema aparece automaticamente ao iniciar a app.

---

## 12. Controlo de Versao

Este projeto esta no repositorio `HelloWorldOptional`. Commits realizados:

- `Initial commit`
- `5.3 Building a System Info App`

---

## 13. Dificuldades e Licoes Aprendidas

- Descobrir quais os campos disponiveis no objeto `Build` exigiu consultar a documentacao oficial do Android.
- Usar `trimIndent()` com strings multilinhas em Kotlin tornou o codigo muito mais limpo do que concatenar strings manualmente com `+`.
- O `EditText` foi usado em vez de `TextView` para mostrar o texto — ambos funcionam para mostrar informacao, mas o `EditText` permite ao utilizador selecionar e copiar o texto.

---

## 14. Melhorias Futuras

- Adicionar botao para copiar a informacao para a area de transferencia.
- Mostrar informacao adicional como espaco em disco e memoria RAM disponivel usando `ActivityManager`.
- Tornar o campo apenas de leitura (`android:focusable="false"`) para evitar edicao acidental.

---

## 15. Declaracao de Uso de IA (Obrigatorio)

Esta tarefa foi realizada **sem uso de IA** (AC YES, AI NO). O auto-complete padrao foi utilizado.

A IA (Claude) foi consultada pontualmente apenas para:
- Resolver duvidas sobre quais os campos disponiveis no objeto `android.os.Build`
- Consultar exemplos de utilizacao de `trimIndent()` com strings multilinhas em Kotlin

Todo o restante codigo foi escrito manualmente com base na documentacao oficial do Android (https://developer.android.com/reference/android/os/Build) e do Kotlin (https://kotlinlang.org/docs/home.html).
