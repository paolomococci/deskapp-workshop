yieldUnescaped '<!DOCTYPE html>'
html(lang:'en') {
    head {
        meta('http-equiv':'"Content-Type" content="text/html; charset=utf-8"')
        title('index')
        link(rel: "stylesheet", href: "/webjars/bootstrap/4.5.3/css/bootstrap.min.css")
    }
    body {
        nav(class: 'navbar navbar-expand-md navbar-dark bg-dark fixed-top'){
            a(href: "#", class: "navbar-brand", "index")
            ui(class: 'navbar-nav mr-auto'){
                li(class: 'nav-item active') {
                    a(href: "/address", class: "navbar-brand", "address")
                }
                li(class: 'nav-item') {
                    a(href: "/customer", class: "navbar-brand", "customer")
                }
            }
        }
    }
}
