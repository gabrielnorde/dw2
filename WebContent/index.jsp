<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Home</title>
    <link rel="canonical" href="#">
    <meta name="viewport" content="width=device-width,minimum-scale=1,initial-scale=1">
    <link href="./style.css" rel="stylesheet" type="text/css">
    
    <link href="https://fonts.googleapis.com/css?family=Crimson+Text|Work+Sans:400,700,900&display=swap" rel="stylesheet">


</head>

<body>

    <header>
        <div class="container">
            <a href="/DW2_Projeto">
                <img src="./images/logo.jpg" alt="Logo" title="Logo" width="96px" height="97px" ;>
            </a>
            <nav class="header-menu">
            
                <svg class="menu-close mobile" role="close menu" tabindex="1" class="close-menu-btn"
                    on="tap:mobile-sidebar.toggle" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20">
                    <defs></defs>
                    <path class="a"
                        d="M20,1.143,18.857,0,10,8.857,1.143,0,0,1.143,8.857,10,0,18.857,1.143,20,10,11.143,18.857,20,20,18.857,11.143,10Z"
                        transform="translate(0)"></path>
                </svg>
                <a href="projetos">Conhecer Projetos</a>
                <c:if test="${usuario}">
                  	<c:if test="${usuario.type == coordenador}">
	                	<a href="register-student.jsp"> Cadastrar Aluno</a>
        		        <a href="register-project.jsp"> Cadastrar Projeto</a>         
	                </c:if>
                	Seja bem vindo, ${usuario.login}       
                	<a href="controle?comando=Deslogar">Sair</a>         
                </c:if>
                
                <c:if test="${not usuario}">
	                <a href="login.jsp">Logar</a>
	                <a href="register-coordinator.jsp"> Cadastrar</a>
                </c:if>                
                
            </nav>
            <svg class="menu-open mobile" role="open menu" tabindex="1" class="open-menu-btn"
                on="tap:mobile-sidebar.toggle" id="menu" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 30 18">
                <defs></defs>
                <g transform="translate(-306 -24)">
                    <rect class="a" width="30" height="2" transform="translate(306 24)"></rect>
                    <rect class="a" width="30" height="2" transform="translate(306 32)"></rect>
                    <rect class="a" width="15" height="2" transform="translate(321 40)"></rect>
                </g>
            </svg>
        </div>

    </header>

    <main class='home-main'>
        <section class='home-banners'>
            <img src='./images/banner-1.jpg' alt='Banner 1' title='Banner 1' width='1200' height='565'>
            <img src='./images/banner-2.jpg' alt='Banner 2' title='Banner 2' width='720' height='270'>
            <img src='./images/banner-3.png' alt='Banner 3' title='Banner 3' width='1280' height='573'>
        </section>

        <section class="home-about container">
            <h2> Sobre nós</h2>
            <div class="home-about-container">
                <div class="home-about-video negative-container">
                    <iframe width="560" height="315" src="https://www.youtube.com/embed/Krz50YbHPDE" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                </div>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque lacinia arcu id velit euismod vestibulum. Morbi volutpat metus ac sem sagittis rutrum. Morbi imperdiet lacus a lacus semper, eget semper enim semper. Nunc non nibh massa. Sed vel dignissim justo. Suspendisse in augue rhoncus, ultrices ante et, blandit quam. Aenean tristique ipsum nisl, ullamcorper varius neque placerat sed. Phasellus nec sapien vel est luctus scelerisque. Nullam nec erat diam. Aliquam feugiat eleifend sagittis. </p>
    
            </div>
        </section>

        <section class="home-projects container">
                <h2> Conheça alguns dos nossos Projetos </h2>
                <div class="home-projects-carousel">
                	<c:forEach var="produto" items="${projetos}">
	                    <div class="home-project">
	                        <div>
	                            <h3>${projetos.nome}</h3>
	                            <p><strong> Tipo: </strong> ${projetos.tipo}</p>
	                            <p><strong> Aluno: </strong> ${projetos.aluno}</p>
	                            <p><strong> Coordenador: </strong> ${projetos.coordenador}</p>
	                            <p class='description'><strong> DescriÃ§Ã£o: </strong> <br>${projetos.descricao}</p>
	                        </div>                        
	                    </div>  
                    </c:forEach>  
                    
                    <div class="home-project">
                        <div>
                            <h3>Dispositivo Mobiles e gameficação da vida</h3>
                            <p><strong> Tipo: </strong> Mobile</p>
                            <p><strong> Aluno: </strong> Samuel Henrique dos Reis</p>
                            <p><strong> Coordenador: </strong> Ricardo Amaral</p>
                            <p class="description"><strong> Descrição: </strong> <br>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque lacinia arcu id velit euismod vestibulum.</p>
                        </div>                        
                    </div>    
                    <div class="home-project">
                        <div>
                            <h3>Dispositivo Mobiles e gameficação da vida</h3>
                            <p><strong> Tipo: </strong> Mobile</p>
                            <p><strong> Aluno: </strong> Samuel Henrique dos Reis</p>
                            <p><strong> Coordenador: </strong> Ricardo Amaral</p>
                            <p class="description"><strong> Descrição: </strong> <br>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque lacinia arcu id velit euismod vestibulum.</p>
                        </div>                        
                    </div> 
                    <div class="home-project">
                        <div>
                            <h3>Dispositivo Mobiles e gameficação da vida</h3>
                            <p><strong> Tipo: </strong> Mobile</p>
                            <p><strong> Aluno: </strong> Samuel Henrique dos Reis</p>
                            <p><strong> Coordenador: </strong> Ricardo Amaral</p>
                            <p class="description"><strong> Descrição: </strong> <br>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque lacinia arcu id velit euismod vestibulum.</p>
                        </div>                        
                    </div>             
                </div>
        </section>

    </main>


    <footer>
        <p class='footer-text container'>Â© Copyright 2019 - Todos os direitos reservados.</p>
        <script type='text/javascript' src='./js/jquery.js'></script>
        <script type='text/javascript' src='./js/main.js'></script>
    </footer>

</body>

</html>