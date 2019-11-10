<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Cadastre-se</title>
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
                  	<c:if test="${usuario.type == 'coordenador'}">
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

    <main class='register-main others'>

            <h1 class="title"> Cadastre-se</h1>
            <section class="register-form container">
        
                <div id="respond" class="register-respond">
                    <form  method="post" action="controle"  name="register-form" id="register-form" class="register-form">
        
                        <div class="register-input-div">
                            <span class="form-field-register-message form-field-name-message"></span>
                            <input id="name" name="nome" type="text" value="" required="required ">
                            <label class="register-label-author"> Nome:*</label>
                        </div>
        
                        <div class="register-input-div">
                            <span class="form-field-register-message form-field-cpf-message"></span>
                            <input id="cpf" name="CPF" type="text" value=""required="required">
                            <label class="register-label-cpf"> CPF:*</label>
                        </div>
                        
                        <div class="register-input-div">
                            <span class="form-field-register-message form-field-email-message"></span>
                            <input id="email" name="email" type="email" value="" required="required">
                            <label class="register-label-email"> E-mail:*</label>
                        </div>
        
                        <div class="register-input-div">
                                <span class="form-field-register-message form-field-type-message"></span>
                                <select id="type">
                                    <option name="type" type="text" selected disabled value=""required="required">Selecione</option>
                                    <option name="type" type="text" value="AdicionarCoordenador"required="required">Coordenador</option>
                                    <option name="type" type="text" value="AdicionarConsultor"required="required">Consultor</option>
                                </select>
                                <label class="register-label-especie"> Se cadastrar como:*</label>
                        </div>

                        <div class="register-input-div street">
                            <span class="form-field-register-message form-field-street-message"></span>
                            <input id="street" name="rua" type="street" value="" required="required">
                            <label class="register-label-street"> Rua:*</label>
                        </div>

                        <div class="register-input-div number">
                            <span class="form-field-register-message form-field-number-message"></span>
                            <input id="number" name="number" type="numero" value="" required="required">
                            <label class="register-label-number"> N�mero:*</label>
                        </div>

                        <div class="register-input-div adress">
                            <span class="form-field-register-message form-field-bairro-message"></span>
                            <input id="bairro" name="bairro" type="bairro" value="" required="required">
                            <label class="register-label-bairro"> Bairro:*</label>
                        </div>

                        <div class="register-input-div adress">
                            <span class="form-field-register-message form-field-city-message"></span>
                            <input id="city" name="cidade" type="city" value="" required="required">
                            <label class="register-label-city"> Cidade:*</label>
                        </div>

                        <div class="register-input-div adress">
                            <span class="form-field-register-message form-field-state-message"></span>
                            <select id="state" name="estado">
                                <option name="type" type="text" selected disabled value="" required="required">Selecione</option>
                                <option value="AC">Acre</option>
                                <option value="AL">Alagoas</option>
                                <option value="AP">Amapá</option>
                                <option value="AM">Amazonas</option>
                                <option value="BA">Bahia</option>
                                <option value="CE">Ceará</option>
                                <option value="DF">Distrito Federal</option>
                                <option value="ES">Espírito Santo</option>
                                <option value="GO">Goiás</option>
                                <option value="MA">Maranhão</option>
                                <option value="MT">Mato Grosso</option>
                                <option value="MS">Mato Grosso do Sul</option>
                                <option value="MG">Minas Gerais</option>
                                <option value="PA">Pará</option>
                                <option value="PB">Paraíba</option>
                                <option value="PR">Paraná</option>
                                <option value="PE">Pernambuco</option>
                                <option value="PI">Piauí</option>
                                <option value="RJ">Rio de Janeiro</option>
                                <option value="RN">Rio Grande do Norte</option>
                                <option value="RS">Rio Grande do Sul</option>
                                <option value="RO">Rondônia</option>
                                <option value="RR">Roraima</option>
                                <option value="SC">Santa Catarina</option>
                                <option value="SP">São Paulo</option>
                                <option value="SE">Sergipe</option>
                                <option value="TO">Tocantins</option>
                                <option value="EX">Estrangeiro</option>
                            </select>
                            <label class="register-label-state"> Estado:*</label>
                        </div>
                 
                   		<input id="comando" type=hidden name=comando>
        
                        <button class="form-submit-button"> Cadastrar </button>
        
                    </form>
                </div>
                <span class="register-return-message"></span>
            </section>


    </main>


    <footer>
        <p class='footer-text container'>© Copyright 2019 - Todos os direitos reservados.</p>
        <script type='text/javascript' src='./js/jquery.js'></script>
        <script type='text/javascript' src='./js/main.js'></script>
    </footer>

</body>

</html>