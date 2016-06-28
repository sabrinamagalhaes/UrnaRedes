# Urna Eletrônica

*Projeto desenvolvido para a disciplina SSC0540 - Redes de Computadores*

#### Funcionalidades Básicas

* No lado Cliente é possível:
  1. Acessar uma lista de candidatos válidos
  2. Votar em um candidato válido
  3. Votar nulo
  4. Votar branco
  5. Finalizar as votações e enviar ao servidor os dados
  6. Acessar contagem dos votos
  
* No lado servidor é possível:
  1. Enviar uma lista de candidatos válidos quando requisitado
  2. Salvar dados enviados pelo cliente
  
#### Como executar

* Servidor:
  1. Entre no diretório UrnaRedes/src
  1. Compile o arquivo ServidorPool `javac model/ServidorPool.java`
  2. Execute o arquivo ServidorPool `java model.ServidorPool.java`

* Cliente:
  Execute o arquivo src/view/Tela.java

Obs: O projeto está configurado para ser rodado no Cluster Cosmos, na porta 40005.
  
