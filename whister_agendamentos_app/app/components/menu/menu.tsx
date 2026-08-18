import Link from "next/link";

export const Menu = () => {
   return (
        <div>
            <div>
                Logo do centro médico
            </div>
            <div>
                <BotaoMenuBar nome="Home" href="/"/>
                <BotaoMenuBar nome="Consultas" href="/"/>
                <BotaoMenuBar nome="Médicos" href="/"/>
                <BotaoMenuBar nome="Pacientes" href="/"/>
                <BotaoMenuBar nome="Planos" href="/"/>
                <BotaoMenuBar nome="Sala" href="/"/>
            </div>

            <div>
                usuario logado
            </div>
        </div>
    )
}

interface BotaoMenuBarProps{
    nome: string;
    href: string;
}
const BotaoMenuBar: React.FC<BotaoMenuBarProps> = ({nome, href}) => {
    return (
        <Link href={href}>
            <button>{nome}</button>
        </Link>
    );
}