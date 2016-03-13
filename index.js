var Reveal = require('reveal.js');
var Markdown = require('reveal.js/plugin/markdown/markdown');
var hljs = require('highlightjs/highlight.pack.js');
require('highlightjs/styles/railscasts.css');
hljs.initHighlightingOnLoad();
require('reveal.js/css/reveal.css');
require('reveal.js/css/theme/white.css');
if (window.location.search === '?print-pdf') {
  require('reveal.js/css/print/pdf.css');
}

Markdown.initialize();

Reveal.initialize({
  controls: true,
  progress: true,
  history: true,
  center: true,
  transition: 'Convex',
});