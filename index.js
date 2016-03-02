var Reveal = require('reveal.js');
var Markdown = require('reveal.js/plugin/markdown/markdown');
require('reveal/index.css');
require('reveal/theme/default.css');

console.log('---------------------');
console.log(Markdown);
console.log('---------------------');

// Reveal.initialize();

Reveal.initialize({
  controls: true,
  progress: true,
  history: true,
  center: true
});

Markdown.initialize();