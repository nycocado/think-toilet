# Think Toilet - [IADE](https://www.iade.europeia.pt/) - [UE](https://www.europeia.pt/)  
![IADE LOGO PNG](Documentos/images/iade_logo.png)
**Universidade:** [Universidade Europeia](https://www.europeia.pt/)  
**Faculdade:** [IADE - Faculdade de Design, Tecnologia e Comunicação](https://www.iade.europeia.pt/)  
**Repositório:** [think-toilet](https://github.com/nycocado/think-toilet)  
**Curso:** Engenharia Informática

## Índice
- [Elementos do Grupo](#elementos-do-grupo)
- [Palavras-Chave](#palavras-chave)
- [Descrição](#descrição)
    - [Motivação](#motivação)
    - [Objetivo](#objetivos)
- [Público Alvo](#público-alvo)
- [Pesquisa de Mercado](#pesquisa-de-mercado)
    - [Where is the Toilet](#where-is-the-toilet)
    - [Berlin Toilet](#berlin-toilet)
    - [Flush](#flush)
    - [Where is Public Toilet](#where-is-public-toilet)
- [Guiões de Teste](#guiões-de-teste)
    - [Primeiro Caso (Core)](#1ª-caso-core---localizar-a-melhor-casa-de-banho-próxima)
    - [Segundo Caso](#2ª-caso---feedback-da-casa-de-banho)
    - [Terceiro Caso](#3ª-caso---pesquisar-casa-de-banho-especifica)
- [Project Charter](#project-charter)
    - [Descrição da Solução](#descrição-da-solução)
    - [Enquadramento nas Unidades Curriculares](#enquadramento-nas-unidades-curriculares)
    - [Requisitos Técnicos](#requisitos-técnicos)

## Elementos do Grupo:
- [Nycolas Souza](https://github.com/nycocado) - 20230989
- [Luan Ribeiro](https://github.com/Ninjaok) - 20230692
- [Lohanne Guedes](https://github.com/Lohannecristina) - 20220085

## Palavras-Chave
Localizador; Avaliação; Sanitários; Casa de banho; Público; Privada; Busca; Próximas; Aplicação; Mobile; Guia; Navegação; Google Maps; Encontrar; Rotas; Busca; Mapa; Interativo; App; Recomendação;

## Descrição
O **Think Toilet** é uma aplicação móvel projetada para resolver um problema comum: localizar casas de banho limpas e acessíveis. Muitas vezes, as pessoas enfrentam dificuldades para encontrar uma casa de banho, especialmente em situações de emergência ou em áreas desconhecidas.

A aplicação permite que os usuários encontrem as casas de banho mais bem avaliadas nas proximidades, em restaurantes, cafés, shoppings e outros estabelecimentos privados, além de espaços públicos. Com um sistema de avaliação integrado, os usuários podem compartilhar suas experiências e sugerir novos locais, enriquecendo o banco de dados da aplicação. Além disso, o Think Toilet oferece um mapa interativo com rotas diretas até os banheiros, utilizando o Google Maps para uma navegação fácil e eficiente.

### Motivação
O **"Spreadshit"** foi um evento muito famoso em 2022 que se tornou viral nas redes sociais. Durante esse período, popularizou-se a prática de fazer reviews humorísticas sobre casas de banho. Esse fenômeno foi impulsionado pela pandemia de COVID-19, que resultou no fechamento de muitas casas de banho públicas, tornando a busca por um banheiro acessível um verdadeiro desafio para muitas pessoas.

Com o fechamento temporário de estabelecimentos e a insegurança em relação à limpeza e ao estado dos banheiros disponíveis, muitas pessoas começaram a compartilhar suas experiências online. Isso não apenas gerou risadas, mas também criou uma comunidade de usuários dispostos a ajudar uns aos outros a encontrar opções mais limpas e seguras.

Além disso, a maioria dos sistemas de busca para casas de banho não é devidamente atualizada, o que dificulta ainda mais a vida dos usuários que precisam urgentemente de um banheiro. Com essa análise em mente, percebemos a necessidade de uma solução prática e eficaz. Por isso, queremos desenvolver uma aplicação que não só ajude as pessoas a encontrar casas de banho limpas e acessíveis, mas que também permita a avaliação e a sugestão de novos locais, contribuindo para um banco de dados mais confiável e útil para todos.

### Objetivos

- Facilitar a busca de casas de banho limpas e próximas.
- Permitir um ambiente saudável para o desenvolvimento da comunidade.
- Avaliação e feedback contínuos.
- Integração com mapas e navegação.
- A comunidade terá um papel ativo na implementação de novas casas de banho.

## Público-Alvo
O público-alvo da aplicação **Think Toilet** inclui:
- Trabalhadores em trânsito, como motoristas e entregadores, que frequentemente necessitam de acesso a casas de banho durante o trabalho.
- Turistas e viajantes que estão explorando novas áreas e precisam localizar sanitários próximos.
- Pessoas com necessidades de acessibilidade, que buscam informações sobre instalações adaptadas.
- Profissionais que trabalham em campo, como trabalhadores da construção civil e eletricistas, que podem não ter acesso a instalações adequadas durante o dia de trabalho.

## Pesquisa de Mercado
A nossa pesquisa sobre aplicativos para busca de casas de banho foi um dos principais motivos para a escolha do tema do projeto. A maioria deles apresenta uma interface deficiente e poucas funções úteis além da localização dos sanitários.

### [Where is the Toilet](https://play.google.com/store/apps/details?id=com.iisrl.toilet.star.toilet_star&hl=pt_PT)
A aplicação funciona como um localizador de casas de banho, permitindo avaliações e a criação de novas.
- **Pontos Positivos:** Interface limpa, sem informações desnecessárias, facilitando a navegação.
- **Pontos Negativos:** Poucas casas de banho disponíveis. Apesar de parecer italiana, não encontrei opções na Itália. O sistema de busca é pouco intuitivo e o mapa não atualiza automaticamente, sendo necessário clicar para mostrar os banheiros próximos.
- **Melhorias Sugeridas:** Automatizar a adição de casas de banho usando APIs e implementar um sistema inteligente para filtrar banheiros próximos ao utilizador.

### [Berlin Toilet](https://play.google.com/store/apps/details?id=com.futurice.berlintoiletapp&hl=pt_PT)
É uma aplicação para localização de casas de banho, utilizando o Google Maps para indicar direções e permitindo avaliações categóricas.
- **Pontos Positivos:** Sistema de localização intuitivo, permite saber se o estabelecimento é pago e oferece acessibilidade.
- **Pontos Negativos:** Interface fraca, não permite comentários sobre as casas de banho e as notas dos utilizadores não aparecem de forma imediata.
- **Melhorias Sugeridas:** Exibir a média de notas dos utilizadores na tela inicial para facilitar a escolha, permitir comentários e melhorar a interface.

### [Flush](https://play.google.com/store/apps/details?id=toilet.samruston.com.toilet&hl=pt_PT)
Aplicação de localização de casas de banho.
- **Pontos Positivos:** Localiza rapidamente banheiros no mapa, indicando se são pagos, acessíveis ou trancados. Permite criar casas de banho e reportar problemas.
- **Pontos Negativos:** Falta filtragem nas criações, avaliações e comentários não aparecem, não mostra as casas de banho mais próximas e não permite traçar rotas.
- **Melhorias Sugeridas:** Filtrar criações de casas de banho, exibir avaliações e comentários, mostrar as mais próximas e permitir rotas.

### [Where is Public Toilet](https://play.google.com/store/apps/details?id=sfcapital.publictoiletinsouthaustralia&hl=pt_PT)
Aplicativo para localizar banheiros públicos, com informações úteis como avaliações e acessibilidade.
- **Pontos Positivos:** Lista de banheiros por distância, com avaliações, horários de funcionamento, favoritos e compartilhamento. Mostra pins no mapa e oferece rota.
- **Pontos Negativos:** Necessita baixar o banco de dados a cada instalação, o que é demorado. Não possui comentários e a interface é confusa e pouco intuitiva.
- **Melhorias Sugeridas:** Mostrar os pins de banheiros registrados ao entrar no aplicativo, adicionar a opção de compartilhamento e incluir um menu com funções extras.

## Guiões de Teste
### Primeiro Caso (Core) - Localizar a melhor casa de banho próxima
Consideramos a localização da melhor casa de banho próxima como o objetivo principal do projeto, seguindo estes passos:
- O utilizador acede à aplicação e visualiza o mapa.
- No mapa, aparecem as casas de banho mais próximas, priorizadas por avaliação. Na parte inferior, é exibida a primeira casa de banho, e o utilizador pode deslizar para ver as cinco mais próximas.
- Independentemente do método escolhido para aceder à casa de banho, o utilizador será redirecionado para a janela da casa escolhida.
- Nessa janela, o utilizador pode clicar no botão escrito "Abrir no Maps", que o levará ao Google Maps, onde poderá escolher a rota até à casa de banho.

### Segundo Caso - Feedback da casa de banho
O segundo caso envolve a avaliação de uma casa de banho:
- O utilizador acede à aplicação e visualiza o mapa.
- No mapa, aparecem as casas de banho mais próximas, priorizadas por avaliação. Na parte inferior, é exibida a primeira casa de banho, e o utilizador pode deslizar para ver as cinco mais próximas.
- Após escolher uma casa de banho, o utilizador é redirecionado para a janela da casa selecionada.
- Nessa janela, o utilizador clica no botão "Avaliar" e é levado à tela de avaliações.
- O utilizador pode comentar sobre a sua experiência e avaliar categorias como "Limpeza", "Papel", "Estrutura" e "Acessibilidade".
  - Opcionalmente, o utilizador pode responder a perguntas adicionais sobre o estado da casa de banho.
- Para concluir, o utilizador clica no botão de confirmação para publicar a sua avaliação.

### Terceiro Caso - Pesquisar casa de banho específica
Este caso trata da busca por uma casa de banho específica pelo utilizador:
- O utilizador acede à aplicação e visualiza o mapa.
- Na parte superior, clica no botão de pesquisa.
- O teclado é acionado, e o utilizador pode digitar a localização ou o nome do estabelecimento onde a casa de banho se encontra.
- O utilizador tem duas possibilidades:
  - Encontrar a casa de banho e visualizar a sua página.
  - Não encontrar, mas ter a opção de sugerir a sua existência.
- O processo termina após a realização da ação desejada.

## Project Charter
### Descrição da Solução
O projeto **[Think Toilet](https://github.com/nycocado/think-toilet)** visa desenvolver uma aplicação móvel que facilita a localização e avaliação de casas de banho próximas. A aplicação exibe um mapa interativo destacando as casas de banho mais bem avaliadas e fornece informações como preço, acessibilidade e se o uso é gratuito, público ou restrito a clientes. Os utilizadores podem avaliar aspetos como limpeza, disponibilidade de papel e estrutura, além de deixar comentários sobre as suas experiências. A aplicação também permite que os utilizadores sugiram novas casas de banho e denunciem locais ou comentários inadequados. Para incentivar a participação, existe um sistema de pontuação que gamifica a experiência do utilizador. Integrada ao Google Maps, a aplicação oferece rotas diretas para facilitar o acesso à casa de banho selecionada.

### Enquadramento das Unidades Curriculares
#### Projeto de Desenvolvimento
Nesta disciplina, iremos planear e gerir todas as etapas do projeto, utilizando ferramentas de gestão para garantir a execução eficiente e dentro dos prazos. Feedbacks de design e desenvolvimento pessoal serão usados para melhorar a qualidade do projeto e desenvolver habilidades técnicas e interpessoais.

#### Programação Mobile
Para o desenvolvimento mobile, usaremos **[Kotlin](https://kotlinlang.org)** como linguagem principal, com **[Jetpack Compose](https://developer.android.com/compose)** no **[Android Studio](https://developer.android.com)**. Começaremos pela implementação de componentes de front-end, criando templates reutilizáveis para diferentes partes da aplicação, o que facilita a manutenção e escalabilidade. Além disso, integraremos APIs externas, como o **[Google Maps API](https://developers.google.com/maps)**, e exibiremos dados dinâmicos, como avaliações e rotas para casas de banho.

#### Programação Orientada a Objetos
Nesta disciplina, usaremos o **[Spring Boot](https://spring.io)** para o back-end, conectando a interface ao banco de dados. O projeto seguirá a arquitetura **REST**, criando APIs que facilitam a comunicação entre o front-end e o back-end. Será utilizado o padrão **MVC** (Model-View-Controller) para separar a lógica de negócios, a interface e os dados. Conceitos como herança e polimorfismo também serão aplicados para otimizar o código em **[Java](https://www.java.com/pt-BR/)**.

#### Bases de Dados
Para gerenciar e armazenar informações, utilizaremos **[MySQL](https://www.mysql.com/)** para criar uma base de dados relacional. Aplicaremos os conhecimentos da disciplina de Bases de Dados para garantir uma estrutura eficiente. Após a criação do banco, conectaremos a interface desenvolvida em **[Kotlin](https://kotlinlang.org)** ao banco de dados usando o **[Spring Boot](https://spring.io)**.

#### Matemática Discreta
A disciplina de Matemática Discreta fornecerá a lógica necessária para o funcionamento do banco de dados, front-end e back-end. Conceitos como grafos, lógica proposicional e teoria dos conjuntos serão utilizados para resolver problemas de organização e acesso eficiente a dados, garantindo uma lógica de controle e validação robusta e segura.

#### Competências Comunicacionais
Esta disciplina será essencial para melhorar a comunicação interna da equipa e externa com clientes e utilizadores. Também fornecerá feedback sobre design e desenvolvimento pessoal, ajudando a melhorar a interface e a experiência do utilizador, garantindo que o projeto atenda às expectativas.

### Requisitos Técnicos
#### Desenvolvimento Móvel
- Linguagem: **[Kotlin](https://kotlinlang.org)** com **[Jetpack Compose](https://developer.android.com/compose)**.
- Mínimo: Android 9.
- SDK: **[Android SDK 28](https://developer.android.com/tools/releases/platforms#9.0)**.
- Navegação e interação com o usuário.
- Integração com APIs externas (ex.: **[Google Maps API](https://developers.google.com/maps)**).

#### Desenvolvimento Back-End
- Spring Boot como framework principal.
- Arquitetura REST para comunicação entre front-end e back-end.
- Manipulação de dados com SQL.

#### Bases de Dados
- Utilização do **[MySQL](https://www.mysql.com/)** para a criação de uma base de dados relacional.
- Conexão entre o banco de dados e a aplicação via **[Spring Boot](https://spring.io)**.

#### Prototipação
- Software: **[Figma](https://www.figma.com/)** para design e prototipagem da interface do usuário.

#### Comunicação e Feedback
- Estabelecimento de canais de comunicação eficazes.
- Coleta de feedback sobre design e interação com o usuário.