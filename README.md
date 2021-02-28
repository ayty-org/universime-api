# Universi.me
## Descrição
Brackend realizado com Springboot para o [Universi.me](http://universi.me "Universi.me")

# Padrão de organização

**Sumário**

[TOCM]

[TOC]

## Documentação completa no Driver
Aqui contém a documentação com as imagens e tutorial passo a passo.
**Documentação .DOCS:** [Clique aqui.](http://https://docs.google.com/document/d/1rbkOsDXkWtgD5eXiYU25iHqjVUIBV-9oHlhJ408XKMw/edit "Clique aqui.")

##  Locais para acompanhamento de atividades
**Hatcher-backend-API:** [Clique Aqui.](http://https://github.com/ayty-org/hatcher-api/projects/1 "Clique Aqui.")
**Hatcher-front-Angular:** [Clique Aqui.](http://https://github.com/ayty-org/hatcher-front-angular/projects/1 "Clique Aqui.")
**Hatcher-front-JSF:** [Clique Aqui.](http://https://github.com/ayty-org/hatcher-front-jsf/projects/1 "Clique Aqui.")

##  Documentação da API utilizando Swagger
**Swagger-API:** [Clique aqui.](http://https://doc-universeme.netlify.app/ "Clique aqui.")

# Acompanhamento de atividades
Existem 4 colunas para verificar o acompanhamento das atividades
- **To do:** Aqui ficam as tarefas não realizadas e que não foram inicializadas.
- **Doing:** Aqui ficam as tarefas que já foram pegas e estão em desenvolvimento.
- **Review:** Aqui fica a tarefa e/ou pull request para análise por algumas outras pessoas, antes de ser concluída. Se for simples, poderá ser concluída sem análise.
- **Done:** Aqui ficam as tarefas que foram concluídas.

# Como utilizar as Labels
Clicando na issue, você pode atribuir as labels necessárias para tal tarefa. Assim definindo seu nível de prioridade.

# Como atribuir uma tarefa ao usuário
Primeiro clique na tarefa desejada (foto1) , após isso clique em Assignees (foto2) e então adicione um usuário (foto3).

#  Método utilizado para padronizar as branches
As branches vão seguir uma padronização semelhante ao Gitflow, onde cada branch é responsável por algo e devem seguir um padrão na sua nomenclatura, para assim facilitar o acompanhamento de atividades e comunicação entre os times.

**Tipos de branch:**
- **feature/ :** São branches no qual são desenvolvidos recursos novos para o projeto em questão.
- **bug/ :** São branches no qual são realizadas a correção de bugs.
- **dev/ :** É a branch que contém código em nível preparatório para o próximo deploy. Ou seja, quando features são terminadas, elas são juntadas com a branch develop, testadas e assim prontas para irem ao branch principal.
- **refactor/ :** É uma branch realizada para quando há apenas refatoramento de um código.
- **master :** É a branch que possui código em produção.

> Obs.> Obs. A branch **Dev/Main** contém a última versão funcional para os desenvolvedores.

## Como encontrar o identificador da issue/task
Toda Issue/Task possui um identificador, você pode encontrá-lo facilmente ao lado ou embaixo do nome dela.
## Como nomear uma branch
Para nomear uma branch, utilize o tipo dela, o identificador da issue/tasks e mais algo que a faça identificável.
**Exemplo:  **
Ex1. Eu quero fazer uma nova funcionalidade de listar Usuário, então minha branch ficará assim…
`feature/18-listar-usuario`
Ex2. Eu preciso fazer um refatoramento de tal branch ou código, então…
`refactor/19-listar-usuario`

# Padronização de commits
Para a padronização de commit, você pode commitar de forma mais livre, contanto que siga estes passos…

Primeiro é preciso adicionar uma versão inicial (x.y.z) e no final a atividade que foi realizada.
Isto é bom caso você queira fazer algum versionamento no commit.
> **Obs.: Não é obrigatório.**

## Versão de commit
Todo commit possuirá uma versão. Essas versões possuem 3 campos (X,Y,Z). Começando de 1.0.0 e cada variável pode atingir o valor máximo 99 antes de trocar para outro campo.

**Exemplo: **
Ex1. Eu quero fazer um novo commit de listar Usuário, então meu commit ficará assim…
`git commit -m “1.0.0: Listagem de usuário semi finalizada" `

Ex2. Eu preciso commitar o refatoramento para subir para o git, então…
`git commit -m “1.0.99: Refatoramento finalizado"`
