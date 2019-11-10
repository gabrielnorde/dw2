/*! VM Mask */
!function(a,b){"function"==typeof define&&define.amd?define(b):a.VMasker=b()}(this,function(){var a="9",b="A",c="S",d=[8,9,16,17,18,36,37,38,39,40,91,92,93],e=function(a){for(var b=0,c=d.length;c>b;b++)if(a==d[b])return!1;return!0},f=function(a){return a=a||{},a={precision:a.hasOwnProperty("precision")?a.precision:2,separator:a.separator||",",delimiter:a.delimiter||".",unit:a.unit&&a.unit.replace(/[\s]/g,"")+" "||"",suffixUnit:a.suffixUnit&&" "+a.suffixUnit.replace(/[\s]/g,"")||"",zeroCents:a.zeroCents,lastOutput:a.lastOutput},a.moneyPrecision=a.zeroCents?0:a.precision,a},g=function(a){this.elements=a};g.prototype.unbindElementToMask=function(){for(var a=0,b=this.elements.length;b>a;a++)this.elements[a].lastOutput="",this.elements[a].onkeyup=!1,this.elements[a].onkeydown=!1,this.elements[a].value.length&&(this.elements[a].value=this.elements[a].value.replace(/\D/g,""))},g.prototype.bindElementToMask=function(a){for(var b=this,c=function(c){c=c||window.event;var d=c.target||c.srcElement;e(c.keyCode)&&setTimeout(function(){b.opts.lastOutput=d.lastOutput,d.value=h[a](d.value,b.opts),d.lastOutput=d.value,d.setSelectionRange&&b.opts.suffixUnit&&d.setSelectionRange(d.value.length,d.value.length-b.opts.suffixUnit.length)},0)},d=0,f=this.elements.length;f>d;d++)this.elements[d].lastOutput="",this.elements[d].onkeyup=c,this.elements[d].value.length&&(this.elements[d].value=h[a](this.elements[d].value,this.opts))},g.prototype.maskMoney=function(a){this.opts=f(a),this.bindElementToMask("toMoney")},g.prototype.maskNumber=function(){this.opts={},this.bindElementToMask("toNumber")},g.prototype.maskPattern=function(a){this.opts={pattern:a},this.bindElementToMask("toPattern")},g.prototype.unMask=function(){this.unbindElementToMask()};var h=function(a){if(!a)throw new Error("VanillaMasker: There is no element to bind.");var b="length"in a?a.length?a:[]:[a];return new g(b)};return h.toMoney=function(a,b){if(b=f(b),b.zeroCents){b.lastOutput=b.lastOutput||"";var c="("+b.separator+"[0]{0,"+b.precision+"})",d=new RegExp(c,"g"),e=a.toString().replace(/[\D]/g,"").length||0,g=b.lastOutput.toString().replace(/[\D]/g,"").length||0;a=a.toString().replace(d,""),g>e&&(a=a.slice(0,a.length-1))}var h=a.toString().replace(/[\D]/g,""),i=new RegExp("^(0|\\"+b.delimiter+")"),j=new RegExp("(\\"+b.separator+")$"),k=h.substr(0,h.length-b.moneyPrecision),l=k.substr(0,k.length%3),m=new Array(b.precision+1).join("0");k=k.substr(k.length%3,k.length);for(var n=0,o=k.length;o>n;n++)n%3===0&&(l+=b.delimiter),l+=k[n];if(l=l.replace(i,""),l=l.length?l:"0",!b.zeroCents){var p=h.length-b.precision,q=h.substr(p,b.precision),r=q.length,s=b.precision>r?b.precision:r;m=(m+q).slice(-s)}var t=b.unit+l+b.separator+m+b.suffixUnit;return t.replace(j,"")},h.toPattern=function(d,e){var f,g="object"==typeof e?e.pattern:e,h=g.replace(/\W/g,""),i=g.split(""),j=d.toString().replace(/\W/g,""),k=j.replace(/\W/g,""),l=0,m=i.length;for(f=0;m>f;f++){if(l>=j.length){if(h.length==k.length)return i.join("");break}i[f]===a&&j[l].match(/[0-9]/)||i[f]===b&&j[l].match(/[a-zA-Z]/)||i[f]===c&&j[l].match(/[0-9a-zA-Z]/)?i[f]=j[l++]:(i[f]===a||i[f]===b||i[f]===c)&&(i=i.slice(0,f))}return i.join("").substr(0,f)},h.toNumber=function(a){return a.toString().replace(/(?!^-)[^0-9]/g,"")},h});

var open_menu = document.querySelector('.menu-open');
var close_menu = document.querySelector('.menu-close');
var menu = document.querySelector('.header-menu');

if(open_menu){
    open_menu.addEventListener('click', function(){
        menu.style.transform = "translate(0)";
    })
}

if(close_menu){
    close_menu.addEventListener('click', function(){
        menu.style.transform = "translate(100vw)";
    })
}


var required_field = "Campo Obrigatório";
var cpf_invalid = "Raça inválido";


function validatecpf(cpf) {
    var regex_cpf = /^[a-z0-9_\-\.]+\@[a-z0-9]+\.[a-z]+$/;
    return regex_cpf.test(cpf);
}

function validatePhone(phone) {
    var regex_phone = /^[(][0-9]{2}[)][0-9]{4}[\-][0-9]{4,5}$/;
    return regex_phone.test(phone);
}

function validateDate(date) {
    var regex_date = /^[0-9]{2}[/][0-9]{2}[/][0-9]{2,4}$/;
    return regex_date.test(date);
}


function validateCPF(cpf) {	
	cpf = cpf.replace(/[^\d]+/g,'');	
	if(cpf == '') return false;	
	// Elimina CPFs invalidos conhecidos	
	if (cpf.length != 11 || 
		cpf == "00000000000" || 
		cpf == "11111111111" || 
		cpf == "22222222222" || 
		cpf == "33333333333" || 
		cpf == "44444444444" || 
		cpf == "55555555555" || 
		cpf == "66666666666" || 
		cpf == "77777777777" || 
		cpf == "88888888888" || 
		cpf == "99999999999")
			return false;		
	// Valida 1o digito	
	add = 0;	
	for (i=0; i < 9; i ++)		
		add += parseInt(cpf.charAt(i)) * (10 - i);	
		rev = 11 - (add % 11);	
		if (rev == 10 || rev == 11)		
			rev = 0;	
		if (rev != parseInt(cpf.charAt(9)))		
			return false;		
	// Valida 2o digito	
	add = 0;	
	for (i = 0; i < 10; i ++)		
		add += parseInt(cpf.charAt(i)) * (11 - i);	
	rev = 11 - (add % 11);	
	if (rev == 10 || rev == 11)	
		rev = 0;	
	if (rev != parseInt(cpf.charAt(10)))
		return false;		
	return true;   
}

function inputHandler(masks, max, event) {
	var c = event.target;
	var v = c.value.replace(/\D/g, '');
	var m = c.value.length > max ? 1 : 0;
	VMasker(c).unMask();
	VMasker(c).maskPattern(masks[m]);
	c.value = VMasker.toPattern(v, masks[m]);
}


var cpf = document.querySelector('.register-input-div #cpf');
var cpfMask = ['999.999.999-99'];
	
if(cpf){
	VMasker(cpf).maskPattern(cpfMask[0]);
	cpf.addEventListener('input', inputHandler.bind(undefined, cpfMask, 18), false);
}



if (document.querySelector('.student .register-form .form-submit-button')) {
	var form =  document.querySelector('.register-form form')
    document.querySelector('.student .register-form .form-submit-button').addEventListener('click', function(e) {
        e.preventDefault();
        var input_name = document.querySelector('.register-form #name').value;
        var input_cpf = document.querySelector('.register-form #cpf').value;
        var input_email = document.querySelector('.register-form #email').value;
        var input_course = document.querySelector('.register-form #course').value;

        var error = false;

        var all_fields_message = document.querySelectorAll('.form-field-register-message');

        for (i = 0; i < all_fields_message.length; i++) {
            all_fields_message[i].innerHTML = "";
        }

        if (input_name.trim() == '') {
            document.querySelector('.form-field-name-message').innerHTML = required_field;
            error = true;
        }
        if (input_cpf.trim() == '') {
            document.querySelector('.form-field-cpf-message').innerHTML = required_field;
            error = true;
        } else if(!validateCPF(input_cpf)){
            document.querySelector('.form-field-cpf-message').innerHTML = 'CPF Inválido';
            error = true;
        }
        if (input_email.trim() == '') {
            document.querySelector('.form-field-email-message').innerHTML = required_field;
            error = true;
        }
        if (input_course.trim() == '') {
            document.querySelector('.form-field-course-message').innerHTML = required_field;
            error = true;
        }


        if (!error) {
        	form.submit();
        }

    });
}

if (document.querySelector('.others .register-form .form-submit-button')) {
	var form =  document.querySelector('.register-form form')
    document.querySelector('.others .register-form .form-submit-button').addEventListener('click', function(e) {
        e.preventDefault();
        var input_name = document.querySelector('.register-form #name').value;
        var input_cpf = document.querySelector('.register-form #cpf').value;
        var input_email = document.querySelector('.register-form #email').value;
        var input_street = document.querySelector('.register-form #street').value;
        var input_number = document.querySelector('.register-form #number').value;
        var input_bairro = document.querySelector('.register-form #bairro').value;
        var input_city = document.querySelector('.register-form #city').value;
        var input_type = document.querySelector('.register-form #type');
        var input_comando = document.querySelector('.register-form #comando')
        var input_type_selected = input_type.options[input_type.selectedIndex].value;
        var input_state = document.querySelector('.register-form #state')
        var input_state_selected = input_state.options[input_state.selectedIndex].value;
     
        var error = false;

        var all_fields_message = document.querySelectorAll('.form-field-register-message');

        for (i = 0; i < all_fields_message.length; i++) {
            all_fields_message[i].innerHTML = "";
        }

        if (input_name.trim() == '') {
            document.querySelector('.form-field-name-message').innerHTML = required_field;
            error = true;
        }
        if (input_cpf.trim() == '') {
            document.querySelector('.form-field-cpf-message').innerHTML = required_field;
            error = true;
        } else if(!validateCPF(input_cpf)){
            document.querySelector('.form-field-cpf-message').innerHTML = 'CPF Inválido';
            error = true;
        }
        if (input_email.trim() == '') {
            document.querySelector('.form-field-email-message').innerHTML = required_field;
            error = true;
        }
        if (input_street.trim() == '') {
            document.querySelector('.form-field-street-message').innerHTML = required_field;
            error = true;
        }
        if (input_number.trim() == '') {
            document.querySelector('.form-field-number-message').innerHTML = required_field;
            error = true;
        }
        if (input_bairro.trim() == '') {
            document.querySelector('.form-field-bairro-message').innerHTML = required_field;
            error = true;
        }
        if (input_city.trim() == '') {
            document.querySelector('.form-field-city-message').innerHTML = required_field;
            error = true;
        }
        if(input_type_selected == ''){
            document.querySelector('.form-field-type-message').innerHTML = required_field;
            error = true;
        }      
        if(input_state_selected == ''){
            document.querySelector('.form-field-state-message').innerHTML = required_field;
            error = true;
        }


        if (!error) {        	
        	input_comando.value = input_type_selected;
        	console.log(form)
        	form.submit();
        }

    });
}



if (document.querySelector('.login-main .register-form .form-submit-button')) {
	var form =  document.querySelector('.register-form form')
    document.querySelector('.login-main .register-form .form-submit-button').addEventListener('click', function(e) {
        e.preventDefault();
        var input_name = document.querySelector('.register-form #name').value;
        var input_cpf = document.querySelector('.register-form #cpf').value;

        var error = false;

        var all_fields_message = document.querySelectorAll('.form-field-register-message');

        for (i = 0; i < all_fields_message.length; i++) {
            all_fields_message[i].innerHTML = "";
        }

        if (input_name.trim() == '') {
            document.querySelector('.form-field-name-message').innerHTML = required_field;
            error = true;
        }
        if (input_cpf.trim() == '') {
            document.querySelector('.form-field-cpf-message').innerHTML = required_field;
            error = true;
        } 
        
        if (!error) {
        	form.submit();
        }

    });
}



if($('.home-banners')){

    $('.home-banners').slick(
        {
            dots: true,
            infinite: false,
            speed: 300,
            slidesToShow: 1,
            slidesToScroll: 1,
            arrows: false,
            dots:true,
            autoplay: true,
            autoplaySpeed: 2000,
          }
    );    

}


if($('.home-projects-carousel')){
    var  slick_active = false;

    var $windowWidth = $(window).width();

    if ($windowWidth < 1200) {
        slick_active = true;
        slickify();   
    }

    $(window).resize(function(){
        var $windowWidth = $(window).width();
        if ($windowWidth < 1200) {
            if(!slick_active){
                slickify();   
            }
        } else {
            slick_active = false;
            deslickify();
        }
    });

    function slickify(){
        $('.home-projects-carousel').slick(
            {
                dots: true,
                infinite: false,
                speed: 300,
                slidesToShow: 2,
                slidesToScroll: 1,
                dots:true,
                arrows: false,
                responsive: [
                  {
                    breakpoint: 600,
                    settings: {
                      slidesToShow: 1,
                      arrows: false
                    }
                  }
                ]
              }
        );

    }

    function deslickify(){
        $('.home-projects-carousel').slick("unslick");
     }

}



