import $ from 'jquery';
import fit from 'davatron5000/FitText.js';

export function bootstrap() {
  $.get("template", function(data, status){
      $( "#view" ).html(data);
   });
}