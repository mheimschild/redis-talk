var Reveal = require('reveal.js');
var Markdown = require('reveal.js/plugin/markdown/markdown');
var hljs = require('highlightjs/highlight.pack.js');
require('highlightjs/styles/railscasts.css');
hljs.initHighlightingOnLoad();
require('reveal.js/css/reveal.css');
require('reveal.js/css/theme/black.css');
//require('reveal/theme/default.css');

Markdown.initialize();

Reveal.initialize({
  controls: true,
  progress: true,
  history: true,
  center: true
});