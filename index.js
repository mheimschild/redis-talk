var Reveal = require('reveal.js');
var Markdown = require('reveal.js/plugin/markdown/markdown');
require('reveal.js/plugin/markdown/marked');
require('reveal.js/css/reveal.css');
require('reveal.js/css/theme/black.css');
//require('reveal/theme/default.css');

console.log('---------------------');
console.log('---------------------');

// Reveal.initialize();

Markdown.initialize();

Reveal.initialize({
  controls: true,
  progress: true,
  history: true,
  center: true
});