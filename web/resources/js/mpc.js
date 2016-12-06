(function() {
    $.mpc = function(a, c) {
        var b = this;
        if (c == null) {
            c = null
        }
        return $.getJSON(a, function(g) {
            var f, d, h, e;
            if (c !== null) {
                localStorage.mpc = c
            } else {
                if (typeof localStorage.mpc === "undefined") {
                    c = localStorage.mpc = g.config["default"]
                } else {
                    c = localStorage.mpc
                }
            }
            d = g[c];
            e = [];
            for (f in d) {
                h = d[f];
                if ($(f) == "title") {
                    document.title = h;
                    continue
                }
                if (f.length > 0) {
                    e.push($(f).html(d[f]))
                } else {
                    e.push(void 0)
                }
            }
            return e
        })
    }
}).call(this);