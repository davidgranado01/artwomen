$(function() {
  var url = window.location.pathname
  var urlpart = url.split("/")

  switch (urlpart[3]) {
    case "obras.php": $('.nav-link').removeClass('active');$('.nav-link.obras').addClass('active');
    break;
    case "anadir-obra.php": $('.nav-link').removeClass('active');$('.nav-link.obras').addClass('active');
    break;
    case "aprobar-obras.php": $('.nav-link').removeClass('active');$('.nav-link.obras').addClass('active');
    break;
    case "aprobar-enlace.php": $('.nav-link').removeClass('active');$('.nav-link.obras').addClass('active');
    break;
    case "anadir-publicacion-obra.php": $('.nav-link').removeClass('active');$('.nav-link.obras').addClass('active');
    break;
    case "anadir-enlace.php": $('.nav-link').removeClass('active');$('.nav-link.obras').addClass('active');
    break;
    case "artistas.php": $('.nav-link').removeClass('active');$('.nav-link.artistas').addClass('active');
    break;
    case "anadir-artista.php": $('.nav-link').removeClass('active');$('.nav-link.artistas').addClass('active');
    break;
    case "aprobar-artistas.php": $('.nav-link').removeClass('active');$('.nav-link.artistas').addClass('active');
    break;
    case "anadir-publicacion-artista.php": $('.nav-link').removeClass('active');$('.nav-link.artistas').addClass('active');
    break;
    case "cuenta.php": $('.nav-link').removeClass('active');$('.nav-link.cuenta').addClass('active');
    break;
    case "index.php": $('.nav-link').removeClass('active');$('.nav-link.index').addClass('active');
    break;
  }    
}) 