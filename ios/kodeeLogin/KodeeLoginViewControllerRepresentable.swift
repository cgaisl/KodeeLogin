import Foundation
import common
import SwiftUI

struct KodeeLogin: UIViewControllerRepresentable {
    @Binding var email: String
    @Binding var password: String
    let onLogin: () -> Void
    
    @State var emailComposeState: ComposeStateImplementation<NSString>
    @State var passwordComposeState: ComposeStateImplementation<NSString>
    
    
    init(email: Binding<String>, password: Binding<String>, onLogin: @escaping () -> Void) {
        _email = email
        _password = password
        _emailComposeState = State(initialValue: ComposeStateImplementation(value: email.wrappedValue as NSString))
        _passwordComposeState = State(initialValue: ComposeStateImplementation(value: password.wrappedValue as NSString))
        self.onLogin = onLogin
    }
    
    
    func makeUIViewController(context: Context) -> UIViewController {
        KodeeLoginViewControllerKt.KodeeLoginViewController(
            email: emailComposeState,
            password: passwordComposeState,
            onEmailChange: {  email = $0 },
            onPasswordChange: { password = $0 },
            onLogin: { onLogin() }
        )
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {
        emailComposeState.update(value: email as NSString)
        passwordComposeState.update(value: password as NSString)
    }
}
