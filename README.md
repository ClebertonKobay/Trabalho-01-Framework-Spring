
<body>
  <h1>Projeto Pagamentos Futebol</h1>
    <p>URL<code>"http://localhost:8080/api"</code>: url da API</p>
   <h3>EndPoints</h3>

  <div class="route">
    <h3>Rota de Jogador</h3>
    <p>GET <code>"/Jogador"</code>: buscar todos os jogadores</p>
    <p>POST <code>"/Jogador"</code>: criar um novo jogador, deve ser passador um JSON com as informações [nome, email e dataNasc]</p>
    <p>GET <code>"/Jogador/{id}"</code>: buscar um jogador, deve ser informado um id em <code>{id}</code></p>
    <p>PUT <code>"/Jogador/{id}"</code>: atualizar dados de um jogador, deve ser informado um id em <code>{id}</code>, deve ser passador um JSON com as informações [nome, email e dataNasc]</p>
    <p>DELETE <code>"/Jogador/{id}"</code>: deletar um jogador, deve ser informado um id em <code>{id}</code></p>
    <p>DELETE <code>"/Jogador"</code>: deletar todos os jogadores</p>
  </div>

  <div class="route">
    <h3>Rota de Pagamento</h3>
    <p>GET <code>"/pagamentos"</code>: buscar todos os pagamentos</p>
    <p>GET <code>"/pagamentos/jogador/{id}"</code>: buscar todos os pagamentos de um determinado jogador, deve ser informado o id do jogador em <code>{id}</code></p>
    <p>POST <code>"/pagamentos/{id}"</code>: criar um novo pagamento, deve ser informado o id do jogador em <code>{id}</code>, deve ser passador um JSON com as informações [ano, mes e valor]</p>
    <p>GET <code>"/pagamentos/{id}"</code>: buscar um pagamento, deve ser informado um id de pagamento em <code>{id}</code></p>
    <p>PUT <code>"/pagamentos/{id}/{id_jogador}"</code>: atualizar dados de um pagamento, deve ser informado um id de pagamento em <code>{id}</code> e um id de jogador em <code>{id_jogador}</code>, deve ser passador um JSON com as informações [ano, mes e valor]</p>
    <p>DELETE <code>"/pagamentos/{id}"</code>: deletar um pagamento, deve ser informado um id de pagamento em <code>{id}</code></p>
    <p>DELETE <code>"/pagamentos"</code>: deletar todos os pagamentos</p>
  </div>
</body>
