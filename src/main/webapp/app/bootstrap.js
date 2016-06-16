import $ from 'jquery';
import 'davatron5000/FitText.js';
import 'joequery/Stupid-Table-Plugin';

export function bootstrap() {
    console.log($.fn);
    $.get("template", function(data){
        $("#view").html(data);
        $("table").stupidtable();
    });
}