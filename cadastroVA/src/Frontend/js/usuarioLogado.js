 function mostrarUsuarioLogado() {
            const userInfo = document.getElementById('userInfo'); //procura por um elemento no html com a ID 'userInfo'
            const usuarioLogado = localStorage.getItem('usuarioLogado');
            
            if (usuarioLogado) {
                const usuario = JSON.parse(usuarioLogado);
                userInfo.innerHTML = `
                    <h4 class="user-name"> ${usuario.nome}</h4>
                    <a href="login.html" class="logout-btn" onclick="logout()"> Sair </a>
                `;
            } else {     
                window.location.href = 'login.html';
            }
        }
        function logout() {
            localStorage.removeItem('usuarioLogado');
            window.location.href = 'login.html';
        }

        mostrarUsuarioLogado(); //isso aqui executa a função imediatamente.