import $ from 'jquery';
import 'davatron5000/FitText.js';
import 'joequery/Stupid-Table-Plugin';
import history from 'xpepermint/history-events';

export function bootstrap() {
    console.log($.fn);
    if (history.isHistorySupported()) {
      window.addEventListener('changestate', function(e) {
        console.log('URL changed');
      });
      window.history.pushState(null, null, '/template'); // `changestate` will be triggered
    }
    $.get("template", function(data){
        $("#view").html(data);
        $("table").stupidtable();
    });
}