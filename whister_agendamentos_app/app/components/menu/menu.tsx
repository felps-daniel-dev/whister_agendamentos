"use client";

import Link from "next/link";
import { usePathname } from "next/navigation";

export const Menu: React.FC = () => {
  const pathname = usePathname();

  return (
    <aside className="w-64 bg-[#0d1a26] text-slate-300 flex flex-col justify-between h-screen sticky top-0 px-4 py-6 select-none shrink-0 border-r border-slate-800/50">
      <div>
        
        <div className="flex items-center gap-3 px-3 mb-8">
          <div className="w-9 h-9 rounded-xl bg-[#00828a] flex items-center justify-center text-white font-bold shadow-lg shadow-[#00828a]/20">
            <svg className="w-5 h-5 fill-current" viewBox="0 0 24 24">
              <path d="M19 10.5V6a2 2 0 0 0-2-2H7a2 2 0 0 0-2 2v4.5c0 3.1 2.05 5.73 4.88 6.64L9 19.5V21h6v-1.5l-0.88-2.36C16.95 16.23 19 13.6 19 10.5zM12 6a1.5 1.5 0 1 1 0 3 1.5 1.5 0 0 1 0-3z" />
            </svg>
          </div>
          <div>
            <h1 className="font-bold text-white text-base tracking-tight leading-tight">Unimedicos</h1>
            <p className="text-xs text-slate-400 font-medium">Gestão Clínica</p>
          </div>
        </div>

       
        <nav className="space-y-1.5">
          <BotaoMenuBar nome="Home" href="/" isActive={pathname === "/"} icon="home" />
          <BotaoMenuBar nome="Pacientes" href="/paciente" isActive={pathname === "/paciente"} icon="users" />
          <BotaoMenuBar nome="Médicos" href="/medico" isActive={pathname === "/medico"} icon="doctor" />
          <BotaoMenuBar nome="Consultas" href="/consulta" isActive={pathname === "/consulta"} icon="calendar" />
          <BotaoMenuBar nome="Salas" href="/sala" isActive={pathname === "/sala"} icon="room" />
          <BotaoMenuBar nome="Planos" href="/plano" isActive={pathname === "/plano"} icon="shield" />
        </nav>
      </div>

      {/* Usuário Logado */}
      <div className="pt-4 border-t border-slate-800/80 flex items-center gap-3 px-2">
        <div className="w-9 h-9 rounded-full bg-[#00828a]/20 text-[#00828a] flex items-center justify-center font-bold text-sm border border-[#00828a]/30">
          A
        </div>
        <div className="overflow-hidden">
          <p className="text-sm font-semibold text-slate-200 truncate leading-tight">Admin</p>
          <p className="text-xs text-slate-400 truncate">Recepção</p>
        </div>
      </div>
    </aside>
  );
};

interface BotaoMenuBarProps {
  nome: string;
  href: string;
  isActive?: boolean;
  icon?: string;
}

const BotaoMenuBar: React.FC<BotaoMenuBarProps> = ({ nome, href, isActive, icon }) => {
  return (
    <Link href={href} className="block">
      <button
        className={`w-full flex items-center gap-3.5 px-3.5 py-2.5 rounded-xl text-sm font-medium transition-all duration-200 relative group cursor-pointer ${
          isActive
            ? "bg-[#182a3a] text-white shadow-sm font-semibold"
            : "text-slate-400 hover:text-slate-200 hover:bg-[#132230]"
        }`}
      >
        <IconByName name={icon} isActive={isActive} />

        <span className="truncate">{nome}</span>

        {isActive && (
          <span className="absolute right-2.5 w-1.5 h-1.5 rounded-full bg-[#00b4d8] shadow-[0_0_8px_#00b4d8]" />
        )}
      </button>
    </Link>
  );
};

const IconByName = ({ name, isActive }: { name?: string; isActive?: boolean }) => {
  const iconClass = `w-4 h-[#16px] stroke-2 transition-colors ${
    isActive ? "text-[#00b4d8]" : "text-slate-400 group-hover:text-slate-200"
  }`;

  switch (name) {
    case "home":
      return (
        <svg className={iconClass} fill="none" viewBox="0 0 24 24" stroke="currentColor">
          <path strokeLinecap="round" strokeLinejoin="round" d="M4 6a2 2 0 012-2h2a2 2 0 012 2v2a2 2 0 01-2 2H6a2 2 0 01-2-2V6zM14 6a2 2 0 012-2h2a2 2 0 012 2v2a2 2 0 01-2 2h-2a2 2 0 01-2-2V6zM4 16a2 2 0 012-2h2a2 2 0 012 2v2a2 2 0 01-2 2H6a2 2 0 01-2-2v-2zM14 16a2 2 0 012-2h2a2 2 0 012 2v2a2 2 0 01-2 2h-2a2 2 0 01-2-2v-2z" />
        </svg>
      );
    case "users":
      return (
        <svg className={iconClass} fill="none" viewBox="0 0 24 24" stroke="currentColor">
          <path strokeLinecap="round" strokeLinejoin="round" d="M12 4.354a4 4 0 110 5.292M15 21H3v-1a6 6 0 0112 0v1zm0 0h6v-1a6 6 0 00-9-5.197M13 7a4 4 0 11-8 0 4 4 0 018 0z" />
        </svg>
      );
    case "doctor":
      return (
        <svg className={iconClass} fill="none" viewBox="0 0 24 24" stroke="currentColor">
          <path strokeLinecap="round" strokeLinejoin="round" d="M16 7a4 4 0 11-8 0 4 4 0 018 0zM12 14a7 7 0 00-7 7h14a7 7 0 00-7-7z" />
        </svg>
      );
    case "calendar":
      return (
        <svg className={iconClass} fill="none" viewBox="0 0 24 24" stroke="currentColor">
          <path strokeLinecap="round" strokeLinejoin="round" d="M8 7V3m8 4V3m-9 8h10M5 21h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v12a2 2 0 002 2z" />
        </svg>
      );
    case "room":
      return (
        <svg className={iconClass} fill="none" viewBox="0 0 24 24" stroke="currentColor">
          <path strokeLinecap="round" strokeLinejoin="round" d="M19 21V5a2 2 0 00-2-2H7a2 2 0 00-2 2v16m14 0h2m-2 0h-5m-9 0H3m2 0h5m0 0v-5a1 1 0 011-1h2a1 1 0 011 1v5m-4 0h4" />
        </svg>
      );
    case "shield":
      return (
        <svg className={iconClass} fill="none" viewBox="0 0 24 24" stroke="currentColor">
          <path strokeLinecap="round" strokeLinejoin="round" d="M9 12l2 2 4-4m5.618-4.016A11.955 11.955 0 0112 2.944a11.955 11.955 0 01-8.618 3.04A12.02 12.02 0 003 9c0 5.591 3.824 10.29 9 11.622 5.176-1.332 9-6.03 9-11.622 0-1.042-.133-2.052-.382-3.016z" />
        </svg>
      );
    default:
      return null;
  }
};