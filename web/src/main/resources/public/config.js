System.config({
  "transpiler": "traceur",
  "paths": {
    "*": "*.js",
    "github:*": "lib/github/*.js"
  }
});

System.config({
  "map": {
    "css": "github:systemjs/plugin-css@0.1.26",
    "davatron5000/FitText.js": "github:davatron5000/FitText.js@1.2.0",
    "dimsemenov/Magnific-Popup": "github:dimsemenov/Magnific-Popup@1.1.0",
    "joequery/Stupid-Table-Plugin": "github:joequery/Stupid-Table-Plugin@1.0.1",
    "jquery": "github:components/jquery@1.12.4",
    "traceur": "github:jmcriffey/bower-traceur@0.0.88",
    "traceur-runtime": "github:jmcriffey/bower-traceur-runtime@0.0.88",
    "xpepermint/history-events": "github:xpepermint/history-events@1.0.4",
    "github:davatron5000/FitText.js@1.2.0": {
      "jquery": "github:components/jquery@1.12.4"
    },
    "github:dimsemenov/Magnific-Popup@1.1.0": {
      "jquery": "github:components/jquery@1.12.4"
    },
    "github:joequery/Stupid-Table-Plugin@1.0.1": {
      "jquery": "github:components/jquery@1.12.4"
    }
  }
});

