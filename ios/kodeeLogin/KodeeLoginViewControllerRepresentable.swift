import Foundation
import common
import SwiftUI

struct KodeeLogin: UIViewControllerRepresentable {
    @Binding var email: String
    @Binding var password: String
    
    @State var swiftUIInputDelegate: SwiftUIInputDelegate?
    
    func makeUIViewController(context: Context) -> UIViewController {
        KodeeLoginViewControllerKt.KodeeLoginViewController(
            initialEmail: email,
            initialPassword: password,
            updateSwiftUIEmail: { email = $0 },
            updateSwiftUIPassword: { password = $0},
            configureInputDelegate: {
                swiftUIInputDelegate = $0
            }
        )
        
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {
        swiftUIInputDelegate?.onEmailChange(email)
        swiftUIInputDelegate?.onPasswordChange(password)
    }
}
