if ("undefined" == typeof jQuery) throw new Error("jquery-confirm requires jQuery");
var jconfirm, Jconfirm;
! function(a) {
    "use strict";
    a.fn.confirm = function(b, c) {
        return "undefined" == typeof b && (b = {}), "string" == typeof b && (b = {
            content: b,
            title: !!c && c
        }), a(this).each(function() {
            var c = a(this);
            c.on("click", function(d) {
                d.preventDefault();
                var e = a.extend({}, b);
                c.attr("data-title") && (e.title = c.attr("data-title")), c.attr("data-content") && (e.content = c.attr("data-content")), e.$target = c, c.attr("href") && !b.confirm && (e.confirm = function() {
                    location.href = c.attr("href")
                }), a.confirm(e)
            })
        }), a(this)
    }, a.confirm = function(a, b) {
        return "undefined" == typeof a && (a = {}), "string" == typeof a && (a = {
            content: a,
            title: !!b && b
        }), jconfirm(a)
    }, a.alert = function(a, b) {
        return "undefined" == typeof a && (a = {}), "string" == typeof a && (a = {
            content: a,
            title: !!b && b
        }), a.cancelButton = !1, jconfirm(a)
    }, a.dialog = function(a, b) {
        return "undefined" == typeof a && (a = {}), "string" == typeof a && (a = {
            content: a,
            title: !!b && b
        }), a.cancelButton = !1, a.confirmButton = !1, a.confirmKeys = [13], jconfirm(a)
    }, jconfirm = function(b) {
        "undefined" == typeof b && (b = {}), jconfirm.defaults && a.extend(jconfirm.pluginDefaults, jconfirm.defaults);
        var b = a.extend({}, jconfirm.pluginDefaults, b);
        return new Jconfirm(b)
    }, Jconfirm = function(b) {
        a.extend(this, b), this._init()
    }, Jconfirm.prototype = {
        _init: function() {
            var a = this;
            this._rand = Math.round(99999 * Math.random()), this._buildHTML(), this._bindEvents(), setTimeout(function() {
                a.open(), a._watchContent()
            }, 0)
        },
        _buildHTML: function() {
            var b = this;
            this.animation = "anim-" + this.animation.toLowerCase(), this.closeAnimation = "anim-" + this.closeAnimation.toLowerCase(), this.theme = "jconfirm-" + this.theme.toLowerCase(), "anim-none" == this.animation && (this.animationSpeed = 0), this._lastFocused = a("body").find(":focus"), this.$el = a(this.template).appendTo(this.container).addClass(this.theme), this.$el.find(".jconfirm-box-container").addClass(this.columnClass), this.$el.find(".jconfirm-bg").css(this._getCSS(this.animationSpeed, 1)), this.$el.find(".jconfirm-bg").css("opacity", this.opacity), this.$b = this.$el.find(".jconfirm-box").css(this._getCSS(this.animationSpeed, this.animationBounce)).addClass(this.animation), this.$body = this.$b, this.rtl && this.$el.addClass("rtl"), this._contentReady = a.Deferred(), this._modalReady = a.Deferred(), this.$title = this.$el.find(".title"), this.contentDiv = this.$el.find("div.content"), this.$content = this.contentDiv, this.$contentPane = this.$el.find(".content-pane"), this.$icon = this.$el.find(".icon-c"), this.$closeIcon = this.$el.find(".closeIcon"), this.$contentPane.css(this._getCSS(this.animationSpeed, 1)), this.setTitle(), this.setIcon(), this._setButtons(), this.closeIconClass && this.$closeIcon.html('<i class="' + this.closeIconClass + '"></i>'), b._contentHash = this._hash(b.$content.html()), a.when(this._contentReady, this._modalReady).then(function() {
                b.setContent(), b.setTitle(), b.setIcon()
            }), this._getContent(), this._imagesLoaded(), this.autoClose && this._startCountDown()
        },
        _unwatchContent: function() {
            clearInterval(this._timer)
        },
        _hash: function() {
            return btoa(encodeURIComponent(this.$content.html()))
        },
        _watchContent: function() {
            var a = this;
            this._timer = setInterval(function() {
                var b = a._hash(a.$content.html());
                a._contentHash != b && (a._contentHash = b, a.setDialogCenter(), a._imagesLoaded())
            }, this.watchInterval)
        },
        _bindEvents: function() {
            var b = this,
                c = !1;
            this.$el.find(".jconfirm-scrollpane").click(function(a) {
                c || (b.backgroundDismiss ? (b.cancel(), b.close()) : (b.$b.addClass("hilight"), setTimeout(function() {
                    b.$b.removeClass("hilight")
                }, 800))), c = !1
            }), this.$el.find(".jconfirm-box").click(function(a) {
                c = !0
            }), this.$confirmButton && this.$confirmButton.click(function(a) {
                a.preventDefault();
                var c = b.confirm(b.$b);
                b._stopCountDown(), b.onAction("confirm"), ("undefined" == typeof c || c) && b.close()
            }), this.$cancelButton && this.$cancelButton.click(function(a) {
                a.preventDefault();
                var c = b.cancel(b.$b);
                b._stopCountDown(), b.onAction("cancel"), ("undefined" == typeof c || c) && b.close()
            }), this.$closeButton && this.$closeButton.click(function(a) {
                a.preventDefault(), b._stopCountDown(), b.cancel(), b.onAction("close"), b.close()
            }), this.keyboardEnabled && setTimeout(function() {
                a(window).on("keyup." + this._rand, function(a) {
                    b.reactOnKey(a)
                })
            }, 500), a(window).on("resize." + this._rand, function() {
                b.setDialogCenter(!0)
            })
        },
        _getCSS: function(a, b) {
            return {
                "-webkit-transition-duration": a / 1e3 + "s",
                "transition-duration": a / 1e3 + "s",
                "-webkit-transition-timing-function": "cubic-bezier(.36,1.1,.2, " + b + ")",
                "transition-timing-function": "cubic-bezier(.36,1.1,.2, " + b + ")"
            }
        },
        _imagesLoaded: function() {
            var b = this;
            a.each(this.$content.find("img:not(.loaded)"), function(c, d) {
                var e = setInterval(function() {
                    var c = a(d).css("height");
                    "0px" !== c && (a(d).addClass("loaded"), b.setDialogCenter(), clearInterval(e))
                }, 40)
            })
        },
        _setButtons: function() {
            this.$btnc = this.$el.find(".buttons"), this.confirmButton && "" !== a.trim(this.confirmButton) && (this.$confirmButton = a('<button type="button" class="btn">' + this.confirmButton + "</button>").appendTo(this.$btnc).addClass(this.confirmButtonClass)), this.cancelButton && "" !== a.trim(this.cancelButton) && (this.$cancelButton = a('<button type="button" class="btn">' + this.cancelButton + "</button>").appendTo(this.$btnc).addClass(this.cancelButtonClass)), this.confirmButton || this.cancelButton || this.$btnc.hide(), this.confirmButton || this.cancelButton || null !== this.closeIcon || (this.$closeButton = this.$b.find(".closeIcon").show()), this.closeIcon === !0 && (this.$closeButton = this.$b.find(".closeIcon").show())
        },
        setTitle: function(a) {
            this.title = "undefined" != typeof a ? a : this.title, this.$title.html(this.title || "")
        },
        setIcon: function(a) {
            this.title = "undefined" != typeof string ? a : this.title, this.$icon.html(this.icon ? '<i class="' + this.icon + '"></i>' : "")
        },
        setContent: function(a) {
            this.content = "undefined" == typeof a ? this.content : a, "" == this.content ? (this.$content.html(this.content), this.$contentPane.hide()) : (this.$content.html(this.content), this.$contentPane.show()), this.$content.hasClass("loading") && (this.$content.removeClass("loading"), this.$btnc.find("button").prop("disabled", !1))
        },
        _getContent: function(b) {
            var c = this;
            if (b = b ? b : this.content, this._isAjax = !1, this.content)
                if ("string" == typeof this.content)
                    if ("url:" === this.content.substr(0, 4).toLowerCase()) {
                        this._isAjax = !0, this.$content.addClass("loading"), this.$btnc.find("button").prop("disabled", !0);
                        var d = this.content.substring(4, this.content.length);
                        a.get(d).done(function(a) {
                            c.content = a, c._contentReady.resolve()
                        }).always(function(a, b, d) {
                            "function" == typeof c.contentLoaded && c.contentLoaded(a, b, d)
                        })
                    } else this.setContent(this.content), this._contentReady.reject();
            else if ("function" == typeof this.content) {
                this.$content.addClass("loading"), this.$btnc.find("button").attr("disabled", "disabled");
                var e = this.content(this);
                "object" != typeof e ? console.error("The content function must return jquery promise.") : "function" != typeof e.always ? console.error("The object returned is not a jquery promise.") : (this._isAjax = !0, e.always(function(a, b) {
                    c._contentReady.resolve()
                }))
            } else console.error("Invalid option for property content, passed: " + typeof this.content);
            else this.content = "", this.setContent(this.content), this._contentReady.reject();
            this.setDialogCenter()
        },
        _stopCountDown: function() {
            clearInterval(this.timerInterval), this.$cd && this.$cd.remove()
        },
        _startCountDown: function() {
            var b = this.autoClose.split("|");
            if (/cancel/.test(b[0]) && "alert" === this.type) return !1;
            if (/confirm|cancel/.test(b[0])) {
                this.$cd = a('<span class="countdown">').appendTo(this["$" + b[0] + "Button"]);
                var c = this;
                c.$cd.parent().click();
                var d = b[1] / 1e3;
                this.timerInterval = setInterval(function() {
                    c.$cd.html(" (" + (d -= 1) + ")"), 0 === d && (c.$cd.html(""), c.$cd.parent().trigger("click"), clearInterval(c.timerInterval))
                }, 1e3)
            } else console.error("Invalid option " + b[0] + ", must be confirm/cancel")
        },
        reactOnKey: function b(c) {
            var d = a(".jconfirm");
            if (d.eq(d.length - 1)[0] !== this.$el[0]) return !1;
            var b = c.which;
            return (!this.contentDiv.find(":input").is(":focus") || !/13|32/.test(b)) && (a.inArray(b, this.cancelKeys) !== -1 && (this.$cancelButton ? this.$cancelButton.click() : this.close()), void(a.inArray(b, this.confirmKeys) !== -1 && this.$confirmButton && this.$confirmButton.click()))
        },
        setDialogCenter: function() {
            if ("none" == this.$contentPane.css("display")) var b = 0,
                c = 0;
            else {
                var b = this.$content.outerHeight(),
                    c = this.$contentPane.height();
                0 == c && (c = b)
            }
            var d = 100,
                e = this.$content.outerWidth();
            this.$content.css({
                clip: "rect(0px " + (d + e) + "px " + b + "px -" + d + "px)"
            }), this.$contentPane.css({
                height: b
            });
            var f = a(window).height(),
                g = this.$b.outerHeight() - c + b,
                h = (f - g),
                i = 100;
            if (g > f - i) {
                var j = {
                    "margin-top": h
                };
                a("body").addClass("jconfirm-noscroll")
            } else {
                var j = {
                    "margin-top": 2 * i,
                    "margin-bottom": i / 2
                };
                a("body").removeClass("jconfirm-noscroll")
            }
            this.$b.css(j)
        },
        close: function() {
            var b = this;
            if (this.isClosed()) return !1;
            "function" == typeof this.onClose && this.onClose(), this._unwatchContent(), b._lastFocused.focus(), a(window).unbind("resize." + this._rand), this.keyboardEnabled && a(window).unbind("keyup." + this._rand), b.$el.find(".jconfirm-bg").removeClass("seen"), a("body").removeClass("jconfirm-noscroll"), this.$b.addClass(this.closeAnimation);
            var c = "anim-none" == this.closeAnimation ? 0 : this.animationSpeed;
            return setTimeout(function() {
                b.$el.remove()
            }, 25 * c / 100), jconfirm.record.closed += 1, jconfirm.record.currentlyOpen -= 1, !0
        },
        open: function() {
            var a = this;
            if (this.isClosed()) return !1;
            a.$el.find(".jconfirm-bg").addClass("seen"), this.$b.removeClass(this.animation), this.$b.find("input[autofocus]:visible:first").focus(), jconfirm.record.opened += 1, jconfirm.record.currentlyOpen += 1, "function" == typeof this.onOpen && this.onOpen();
            var b = "jconfirm-box" + this._rand;
            return this.$b.attr("aria-labelledby", b).attr("tabindex", -1).focus(), this.$title ? this.$title.attr("id", b) : this.$content && this.$content.attr("id", b), setTimeout(function() {
                a.$b.css({
                    "transition-property": a.$b.css("transition-property") + ", margin"
                }), a._modalReady.resolve()
            }, this.animationSpeed), !0
        },
        isClosed: function() {
            return "" === this.$el.css("display")
        }
    }, jconfirm.pluginDefaults = {
        template: '<div class="jconfirm"><div class="jconfirm-bg"></div><div class="jconfirm-scrollpane"><div class="container"><div class="row"><div class="jconfirm-box-container"><div class="jconfirm-box" role="dialog" aria-labelledby="labelled" tabindex="-1"><div class="closeIcon">&times;</div><div class="title-c"><span class="icon-c"></span><span class="title"></span></div><div class="content-pane"><div class="content"></div></div><div class="buttons"></div><div class="jquery-clear"></div></div></div></div></div></div></div>',
        title: "Titulo",
        content: "Are you sure to continue?",
        contentLoaded: function() {},
        icon: "",
        opacity: .2,
        confirmButton: "confirmar",
        cancelButton: "Cancelar",
        confirmButtonClass: "btn-default",
        cancelButtonClass: "btn-danger",
        theme: "black",
        animation: "right",
        closeAnimation: "left",
        animationSpeed: 500,
        animationBounce: 1.2,
        keyboardEnabled: !1,
        rtl: !1,
        confirmKeys: [13],
        cancelKeys: [27],
        container: "body",
        confirm: function() {},
        cancel: function() {},
        backgroundDismiss: !1,
        autoClose: !1,
        closeIcon: null,
        closeIconClass: !1,
        watchInterval: 100,
        columnClass: "col-sm-6 col-sm-offset-3 col-xs-12",
        onOpen: function() {},
        onClose: function() {},
        onAction: function() {}
    }, jconfirm.record = {
        opened: 0,
        closed: 0,
        currentlyOpen: 0
    }
}(jQuery);