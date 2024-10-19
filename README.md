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
  - [Primeiro Caso (Core)](#primeiro-caso-core---localizar-a-melhor-casa-de-banho-próxima)
  - [Segundo Caso](#segundo-caso---feedback-da-casa-de-banho)
  - [Terceiro Caso](#terceiro-caso---pesquisar-casa-de-banho-específica)
- [Plano de Trabalho](#plano-de-trabalho)
- [Descrição da Solução](#descrição-da-solução)
- [Enquadramento nas Unidades Curriculares](#enquadramento-nas-unidades-curriculares)
  - [Programação de Dispositivos Móveis](#programação-de-dispositivos-móveis)
  - [Programação Orientada por Objetos](#programação-orientada-por-objetos)
  - [Bases de Dados](#bases-de-dados)
  - [Mátematica Discreta](#matemática-discreta)
  - [Projeto de Desenvolvimento Móvel](#projeto-de-desenvolvimento-móvel)
  - [Competencias Comunicacionais](#competências-comunicacionais)
- [Requisitos Técnicos](#requisitos-técnicos)
  - [Requisitos Funcionais](#requisitos-funcionais)
  - [Requisitos Não Funcionais](#requisitos-não-funcionais)
- [Arquitetura da Solução](#arquitetura-da-solução)
  - [Components da Arquitetura](#componentes-da-arquitetura)
  - [Fluxo de Dados](#fluxo-de-dados)
- [Tecnologias](#tecnologias)

## Elementos do Grupo:
- [Nycolas Souza](https://github.com/nycocado) - 20230989
- [Luan Ribeiro](https://github.com/Ninjaok) - 20230692
- [Lohanne Guedes](https://github.com/Lohannecristina) - 20220085

## Palavras-Chave
Localizador; Avaliação; Sanitários; Casa de banho; Público; Privada; Busca; Próximas; Aplicação; Mobile; Guia; Navegação; Google Maps; Encontrar; Rotas; Busca; Mapa; Interativo; App; Recomendação;

## Descrição
O **Think Toilet** é uma aplicação móvel projetada para resolver um problema comum: localizar casas de banho limpas e acessíveis. Muitas vezes, as pessoas enfrentam dificuldades para encontrar uma casa de banho, especialmente em situações de emergência ou em áreas desconhecidas.

### Motivação
O **"Spreadshit"** foi um evento muito famoso em 2022 que se tornou viral nas redes sociais. Durante esse período, popularizou-se a prática de fazer reviews humorísticas sobre casas de banho. Esse fenômeno foi impulsionado pela pandemia de COVID-19, que resultou no fechamento de muitas casas de banho públicas, tornando a busca por um banheiro acessível um verdadeiro desafio para muitas pessoas.

Com o fechamento temporário de estabelecimentos e a insegurança em relação à limpeza e ao estado dos banheiros disponíveis, muitas pessoas começaram a compartilhar suas experiências online. Isso não apenas gerou risadas, mas também criou uma comunidade de usuários dispostos a ajudar uns aos outros a encontrar opções mais limpas e seguras.

Além disso, a maioria dos sistemas de busca para casas de banho não é devidamente atualizada, o que dificulta ainda mais a vida dos usuários que precisam urgentemente de um banheiro. Com essa análise em mente, percebemos a necessidade de uma solução prática e eficaz. Por isso, queremos desenvolver uma aplicação que não só ajude as pessoas a encontrar casas de banho limpas e acessíveis, mas que também permita a avaliação e a sugestão de novos locais, contribuindo para um banco de dados mais confiável e útil para todos.

### Objetivos

- Facilitar a busca de casas de banho limpas e próximas.
- Permitir um ambiente saudável para o desenvolvimento da comunidade.
- Avaliação e feedback contínuos.
- Integração com mapas e navegação.

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
- **Pontos Negativos:** Poucas casas de banho disponíveis. Apesar de parecer italiana, não encontramos opções na Itália. O sistema de busca é pouco intuitivo e o mapa não atualiza automaticamente, sendo necessário clicar para mostrar os banheiros próximos.
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

## Plano de Trabalho
| **Fase**                            | **Descrição**                                                                                                                                                                                                      | **Prazo**               |
| ----------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ----------------------- |
| **1. Planejamento e Prototipação**  | Definição dos objetivos, escopo e requisitos do projeto. Criação de protótipos da interface de usuário usando Figma.                                                                                               | Entrega 1: [20/10/2024] |
| **2. Desenvolvimento do Protótipo** | Implementação inicial da aplicação móvel em Kotlin com Jetpack Compose.<br> Integração básica com Google Maps.<br> Desenvolvimento inicial do servidor com Spring Boot.<br> Conexão com a base de dados MySQL.     | Entrega 2: [24/11/2024] |
| **3. Desenvolvimento Final**        | Continuação do desenvolvimento da aplicação, incluindo:<br> - Funcionalidades completas de busca, avaliação e sugestão.<br> - Refinamento da integração com Google Maps.<br> - Finalização do servidor e das APIs. | Entrega 3: [12/01/2024] |
| **4. Testes**                       | Realização de testes unitários e de integração da aplicação.<br>Coleta de feedback de usuários e melhorias com base nas avaliações.                                                                                | Entrega 3: [12/01/2024] |
| **5. Documentação**                 | Criação da documentação técnica e do relatório final do projeto.                                                                                                                                                   | Entrega 3: [12/01/2024] |

## Descrição da Solução
O projeto **[Think Toilet](https://github.com/nycocado/think-toilet)** visa desenvolver uma aplicação móvel que facilita a localização e avaliação de casas de banho próximas. A aplicação exibe um mapa interativo destacando as casas de banho mais bem avaliadas e fornece informações como preço, acessibilidade e se o uso é gratuito, público ou restrito a clientes. Os utilizadores podem avaliar aspetos como limpeza, disponibilidade de papel e estrutura, além de deixar comentários sobre as suas experiências. A aplicação também permite que os utilizadores sugiram novas casas de banho e denunciem locais ou comentários inadequados. Para incentivar a participação, existe um sistema de pontuação que gamifica a experiência do utilizador. Integrada ao Google Maps, a aplicação oferece rotas diretas para facilitar o acesso à casa de banho selecionada.

## Enquadramento das Unidades Curriculares
### Programação de Dispositivos Móveis
Para o desenvolvimento mobile, usaremos **[Kotlin](https://kotlinlang.org)** como linguagem principal, com **[Jetpack Compose](https://developer.android.com/compose)** no **[Android Studio](https://developer.android.com)**. Começaremos pela implementação de componentes de front-end, criando templates reutilizáveis para diferentes partes da aplicação, o que facilita a manutenção e escalabilidade. Além disso, integraremos APIs externas, como o **[Google Maps API](https://developers.google.com/maps)**, e exibiremos dados dinâmicos, como avaliações e rotas para casas de banho.

### Programação Orientada por Objetos
Nesta disciplina, usaremos o **[Java](https://www.java.com/)** com **[Spring Boot](https://spring.io)** para o back-end, conectando a interface ao banco de dados. O projeto seguirá a arquitetura **REST**, criando APIs que facilitam a comunicação entre o front-end e o back-end. Será utilizado o padrão **MVC** (Model-View-Controller) para separar a lógica de negócios, a interface e os dados. Conceitos como herança e polimorfismo também serão aplicados para otimizar o código em **[Java](https://www.java.com/)**.

### Bases de Dados
Para gerenciar e armazenar informações, utilizaremos **[MySQL](https://www.mysql.com/)** para criar uma base de dados relacional. Aplicaremos os conhecimentos da disciplina de Bases de Dados para garantir uma estrutura eficiente. Após a criação do banco, conectaremos a interface desenvolvida em **[Kotlin](https://kotlinlang.org)** ao banco de dados usando o **[Spring Boot](https://spring.io)**.

### Matemática Discreta
A disciplina de Matemática Discreta fornecerá a lógica necessária para o funcionamento do banco de dados, front-end e back-end. Conceitos como grafos, lógica proposicional e teoria dos conjuntos serão utilizados para resolver problemas de organização e acesso eficiente a dados, garantindo uma lógica de controle e validação robusta e segura.

### Projeto de Desenvolvimento Móvel
Nesta disciplina, iremos planear e gerir todas as etapas do projeto, utilizando ferramentas de gestão para garantir a execução eficiente e dentro dos prazos. Feedbacks de design e desenvolvimento pessoal serão usados para melhorar a qualidade do projeto e desenvolver habilidades técnicas e interpessoais.

### Competências Comunicacionais
Esta disciplina será essencial para melhorar a comunicação interna da equipa e externa com clientes e utilizadores. Também fornecerá feedback sobre design e desenvolvimento pessoal, ajudando a melhorar a interface e a experiência do utilizador, garantindo que o projeto atenda às expectativas.

## Requisitos Técnicos
### Requisitos Funcionais
- Os usuários devem poder buscar casas de banho próximas por localização no mapa.
- Os usuários devem poder visualizar detalhes das casas de banho, incluindo preço, acessibilidade, condições e avaliações (incluindo nisso a média das avaliações categoricas, e a média das avaliações gerais).
- Os usuários devem poder avaliar casas de banho, deixando comentários e notas sobre limpeza, acessibilidade, disponibilidade de papel e estrutura.
- Os usuários devem poder sugerir novas casas de banho.
- A aplicação deve permitir que os usuários denunciem locais ou comentários inadequados.
- Os usúarios obrigatoriamente devem ser registrados e ter uma conta na plataforma para poder interagir com a comunidade

### Requisitos Não Funcionais
- A interface deve ser intuitiva e responsiva, proporcionando uma experiência de usuário agradável.
- O sistema deve permitir a moderação eficiente de comentários e sugestões, incluindo a análise de conteúdo para determinar se ele deve ser mantido, editado ou removido.
- A aplicação deve ser compatível com Android 9 (API Level 28) ou superior.
- Deve ser utilizado Kotlin com Jetpack Compose para a interface do usúario.
- Deve ser utilizado Java com Spring Boot para manipulação de dados.
- Utilização de MySQL para o armazenamento de dados, incluindo informações sobre usuários, casas de banho, avaliações e sugestões.
- Todos os dados do usuário devem ser criptografados antes de serem armazenados.
- Integração com o Google Maps API para fornecer direções e exibir casas de banho no mapa.

## Arquitetura da Solução
A arquitetura da solução do projeto Think Toilet é projetada para ser modular e escalável, abrangendo três componentes principais: o front-end (aplicação móvel), o back-end (servidor) e o banco de dados.

### Componentes da Arquitetura:
#### Front-end (Aplicação Móvel)
Desenvolvida em **[Kotlin](https://kotlinlang.org)** com **[Jetpack Compose](https://developer.android.com/compose)** para a interface de usuário, a aplicação permitirá aos usuários buscar casas de banho, visualizar detalhes, fazer avaliações e sugerir novos locais. A integração com o **[Google Maps API](https://developers.google.com/maps)** fornecerá um mapa interativo com direções.

#### Back-end (Servidor)
Construído com **[Java](https://www.java.com/)** e **[Spring Boot](https://spring.io)**, o servidor implementará uma arquitetura RESTful para facilitar a comunicação entre o front-end e o back-end. Ele gerenciará dados sobre casas de banho, avaliações e usuários, garantindo a integridade das informações.

#### Banco de Dados
Utilizando **[MySQL](https://www.mysql.com/)**, o banco de dados será projetado para armazenar informações sobre usuários, casas de banho, avaliações e sugestões. A estrutura relacional garantirá eficiência nas consultas e integridade dos dados.

### Fluxo de Dados:
#### Busca de Casas de Banho
- O usuário pesquisa casas de banho na aplicação.
- A aplicação envia uma requisição ao servidor para obter dados das casas de banho.
- O servidor processa a requisição e retorna os dados ao front-end.

#### Avaliação de Casas de Banho
- O usuário seleciona uma casa de banho e fornece uma avaliação.
- A aplicação envia a avaliação ao servidor.
- O servidor armazena a avaliação no banco de dados e pode retornar uma confirmação ao usuário.

#### Sugestão de Novas Casas de Banho
- O usuário sugere uma nova casa de banho.
- A aplicação envia os detalhes da sugestão ao servidor.
- O servidor armazena a sugestão e notifica o usuário sobre a aceitação ou rejeição da proposta.

#### Visualização de Avaliações e Sugestões
- O usuário pode visualizar avaliações de outras casas de banho.
- O servidor responde às requisições de visualização com as avaliações armazenadas.

## Tecnologias
### Desenvolvimento Móvel:
- **Linguagem:** [Kotlin](https://kotlinlang.org)
- **Framework:** [Jetpack Compose](https://developer.android.com/compose)
- **SDK:** [Android SDK 28](https://developer.android.com/tools/releases/platforms#9.0)
- **Integração:** [Google Maps API](https://developers.google.com/maps)

### Desenvolvimento Back-End:
- **Linguagem:** [Java](https://www.java.com/)
- **Framework:** [Spring Boot](https://spring.io)

### Bases de Dados:
- **Sistema de Gerenciamento:** [MySQL](https://www.mysql.com/)
- **Conexão:** via [Spring Boot](https://spring.io)

### Prototipação:
- **Software:** [Figma](https://www.figma.com/) para design e prototipação da interface do usuário.

