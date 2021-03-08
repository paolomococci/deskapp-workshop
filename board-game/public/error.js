window.addEventListener(
    'mousedown', 
    function(event) {
        document.body.classList.add('App-mouse-navigation');
        document.body.classList.remove('App-keyboard-navigation');
    }
);

window.addEventListener(
    'keydown', 
    function(event) {
        if (event.key === "Tab") {
            document.body.classList.add('App-keyboard-navigation');
            document.body.classList.remove('App-mouse-navigation');
        }
    }
);

window.addEventListener(
    'click', 
    function(event) {
        if (event.target.tagName === 'A' && event.target.getAttribute('href') === '#') {
            event.preventDefault();
        }
    }
);

window.onerror = function(
    message, 
    source, 
    line, 
    col, 
    error
) {
    var text = error ? error.stack || error : message + ' (at ' + source + ':' + line + ':' + col + ')';
    errors.textContent += text + '\n';
    errors.style.display = '';
};

console.error = (
    function(old) {
        return function error() {
            errors.textContent += Array.prototype.slice.call(arguments).join(' ') + '\n';
            errors.style.display = '';
            old.apply(this, arguments);
        }
    }
)(console.error);
