Ext.define("MyApp.view.login.Login", {
    extend: "Ext.window.Window",
    xtype: "login",

    title: "Muj Login",
    autoShow: true,
    closeable: false,

    requires: [
        "MyApp.view.login.LoginController",
        "Ext.form.Panel"
    ],

    controller: 'login',

    items: {
        xtype: "form",
        reference: "form",
        items: [
            {
                xtype: "textfield",
                name: "nickname",
                fieldLabel: "nickname",
                allowBlank: false
            }
        ],
        buttons: [
            {
                text: "Login"
            }
        ]
    }
});