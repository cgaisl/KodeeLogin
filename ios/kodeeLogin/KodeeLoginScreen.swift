import SwiftUI

struct KodeeLoginScreen: View {
    
    let onLogin: () -> Void
    
    @State var email: String = ""
    @State var password: String = ""
    
    var body: some View {
        KodeeLogin(
            email: $email,
            password: $password,
            onLogin: { /* do login */ }
        )
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        KodeeLoginScreen {}
//            .previewDevice(PreviewDevice(rawValue: "iPhone 14 Pro"))
    }
}
