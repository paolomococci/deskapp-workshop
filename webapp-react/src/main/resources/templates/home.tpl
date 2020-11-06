yieldUnescaped '<!DOCTYPE html>'
html(lang:'en') {
    head {
        meta('http-equiv': '"Content-Type" content="text/html; charset=utf-8"')
        title('home')
        link(rel: "stylesheet", href: "css/default.css", type: "text/css", media: "all")
    }
    body {
        div(id: "react"){}
        script(src: "js/App.js", type: "text/javascript"){}
    }
}
