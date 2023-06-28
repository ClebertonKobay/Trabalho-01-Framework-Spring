
<body>
  <h1>Projeto Pagamentos Futebol</h1>
    <p>URL<code>"http://localhost:8080/api"</code>: url da API</p>
   <h3>EndPoints</h3>

  <div class="route">
    <h3>Rota de Jogador</h3>
    <p>GET <code>"/Jogador"</code>: Mostra todos os jogadores</p>
    <p>POST <code>"/Jogador"</code>: insere no banco um jogador enviando um JSON com as dados {nome, email e datanasc}</p>
    <p>GET <code>"/Jogador/{id}"</code>: busca um jogador pelo id</p>
    <p>PUT <code>"/Jogador/{id}"</code>: atualiza os dados de um jogador com id informado na url passando um JSON com os dados {nome, email e datanasc}</p>
    <p>DELETE <code>"/Jogador/{id}"</code>: deletar um jogador passando um id</p>
    <p>DELETE <code>"/Jogador"</code>: Apaga todos os jogadores</p>
  </div>

  <div class="route">
    <h3>Rota de Pagamento</h3>
    <p>GET <code>"/pagamentos"</code>: Mostra todos os pagamentos</p>
    <p>POST <code>"/pagamentos/{id}"</code>: insere um pagamento passando o id do jogadore passando um JSON com os dados {ano, mes e valor}</p>
    <p>GET <code>"/pagamentos/{id}"</code>: busca um pagamento pelo id</p>
    <p>PUT <code>"/pagamentos/{id}"</code>: atualiza dados de um pagamento, passando o id do pagamento a ser modificado e passando um JSON com os dados {ano, mes e valor}</p>
    <p>DELETE <code>"/pagamentos/{id}"</code>: Apaga um pagamento pelo id </p>
    <p>DELETE <code>"/pagamentos"</code>: Apaga todos os pagamentos</p>
  </div>
</body>
