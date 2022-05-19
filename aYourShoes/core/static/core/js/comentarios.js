if (!window.hcb_user) {
    hcb_user = {};
}(function() {
    var s = document.createElement("script"),
        l = hcb_user.PAGE ||
        ("" + window.location).replace(/'/g, "%27"),
        h = "https://www.htmlcommentbox.com";
    s.setAttribute("type", "text/javascript");
    s.setAttribute("src", h + "/jread?page=" + encodeURIComponent(l).replace("+", "%2B") + "&mod=%241%24wq1rdBcg%24QSCsVLvyG6I6zRsOnfkIU%2F" + "&opts=16862&num=10&ts=1622523800652");
    if (typeof s != "undefined")
        document.getElementsByTagName("head")[0].appendChild(s);
})();