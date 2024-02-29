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


    const $imagensInf = $("#segunda-imagem");
    const $bowsImage = $("#bows-image");


  $registraMenuOpcao.hide()
  $userMenuOpcao.hide()
  $aceessMenuOpcao.hide()

    $registerButton.on('mouseenter', () => {
     
        $registraMenuOpcao.show(1000);
        $menu.on('mouseleave',()=>{
           $registraMenuOpcao.hide(1000)
        })
    });
  

    $acessButton.on('mouseenter', () => {
     
        $aceessMenuOpcao.show(1000);
        $menu.on('mouseleave',()=>{
           $aceessMenuOpcao.hide(1000)
        })
    });
  
    $userButton.on('mouseenter', () => {
     
        $userMenuOpcao.show(1000);
        $menu.on('mouseleave',()=>{
           $userMenuOpcao.hide(1000)
        })
    });
  
   


    $imagensInf.on('mouseenter',()=>{
        $imagensInf.animate({
            height: '75%',width:'75%' } , 800);
            $imagensInf.on('mouseleave',()=>{
                $imagensInf.animate({
                    height: '60%', width:'60%' } , 800);
            })
    })



    
    $bowsImage.on('mouseenter',()=>{
        $bowsImage.animate({
            height: '100%',width:'100%' } , 800);
            $bowsImage.on('mouseleave',()=>{
                $bowsImage.animate({
                    height: '60%', width:'60%' } , 800);
            })
    })




});
