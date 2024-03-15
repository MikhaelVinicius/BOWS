$(document).ready(() => {

    const $menu = $(".menu");
    
    const $registerButton = $("#register-button");
    const $menuRegistrar = $("#menu-registrar");
    const $registraMenuOpcao = $(".menu-registra-opcao");

    const $acessButton = $("#access-button");
    const $menuAcessar = $("#menu-acessar");
    const $aceessMenuOpcao = $(".menu-acessar-opcao");

    const $userButton = $("#user-button");
    const $menuUser = $("#menu-user");
    const $userMenuOpcao = $(".menu-user-opcao");

    const $dados = $("#dados-container");
    const $dadosSecundarios=$("#dados-secundarios");


    const $imagensInf = $("#segunda-imagem");
    const $bowsImage = $("#bows-image");




    // Função para mostrar e esconder o menu de acessar
    $acessButton.hover(
        function() {
            $aceessMenuOpcao.stop(true, true).slideDown(500);
        },
        function() {
            $aceessMenuOpcao.stop(true, true).slideUp(500);
        }
    );

    // Função para mostrar e esconder o menu de usuário
    $userButton.hover(
        function() {
            $userMenuOpcao.stop(true, true).slideDown(500);
        },
        function() {
            $userMenuOpcao.stop(true, true).slideUp(500);
        }
    );

  $registraMenuOpcao.hide()
  $userMenuOpcao.hide()
  $aceessMenuOpcao.hide()
  $dadosSecundarios

  $registerButton.on('mouseenter', () => {
    setTimeout(() => {
        $registraMenuOpcao.show(500);
        $menu.on('mouseleave', () => {
            $registraMenuOpcao.hide(1000);
        });
    }, 500);
});

$acessButton.on('mouseenter', () => {
    setTimeout(() => {
        $aceessMenuOpcao.show(500);
        $menu.on('mouseleave', () => {
            $aceessMenuOpcao.hide(1000);
        });
    }, 500);
});

$userButton.on('mouseenter', () => {
    setTimeout(() => {
        $userMenuOpcao.show(500);
        $menu.on('mouseleave', () => {
            $userMenuOpcao.hide(500);
        });
    }, 500);
});

$imagensInf.on('mouseenter', () => {
    $imagensInf.animate({
        height: '80%',
        width: '80%'
    }, 800);
    $imagensInf.on('mouseleave', () => {
        $imagensInf.animate({
            height: '60%',
            width: '60%'
        }, 800);
    });
});

$bowsImage.on('mouseenter', () => {
    $bowsImage.animate({
        height: '100%',
        width: '100%'
    }, 800);
    $dados.hide(800);
    $dadosSecundarios.show(800);
    $bowsImage.on('mouseleave', () => {
        $bowsImage.animate({
            height: '60%',
            width: '60%'
        }, 800);
        $dadosSecundarios.hide();
        $dados.show(800);
    });
});




    $(document).delegate('#myForm', 'submit', function(event) {
        event.preventDefault();
    
        // Obtenha os valores dos campos do formulário
        var nome = $('#fnome').val();
        var autor = $('#fautor').val();
        var organizacao = $('#fOrg').val();
        var localizado = $('#floc').val();
        var agente_biologico = $('#fbio').val();
        var info = $('#fInfo').val();

        var formData = {
            nome: nome,
            autor: autor,
            organizacao: organizacao,
            localizado: localizado,
            agente_biologico: agente_biologico,
            info: info
        };

        $.ajax({
            url: "http://localhost:8080/bows/add",
            type: 'POST',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(formData),
            cache: false,
            success: function(response) {
                alert("Formulário enviado com sucesso!");
            },
            error: function(xhr, status, error) {
                console.error(xhr.responseText);
            }
        });
    });


    function getBowsById(id) {
        $.ajax({
            url: "http://localhost:8080/bows/" + id, // Endpoint para recuperar os dados BOWS por ID (ajuste conforme necessário)
            type: "GET",
            contentType: "application/json; charset=utf-8",
            success: function(response) {
                // Limpa o contêiner de dados BOWS antes de adicionar novos dados
                $("#dados-bows-container").empty();
                // Adiciona os dados BOWS ao contêiner
                $("#dados-bows-container").append("<div><h3>Nome: " + response.name + "</h3><p>Autor: " + response.autor + "</p><p>Organização: " + response.organizacao + "</p><p>Localizado em: " + response.localizado + "</p><p>Agente biológico: " + response.agente_biologico + "</p><p>Descrição: " + response.info + "</p></div><hr>");
            },
            error: function(xhr, status, error) {
                console.error(xhr.responseText);
                $("#dados-bows-container").html("Erro ao buscar informações do BOWS.");
            }
        });
    }

    // Adicione um evento de clique ao botão de busca
    $('#buscarBowsBtn').click(function() {
        var id = $('#idInput').val();
        getBowsById(id);
    });

    
    

    
    


})


