import { Menu } from "./menu/menu";

interface LayoutProps {
  children?: React.ReactNode;
}

export const Layout: React.FC<LayoutProps> = (props: LayoutProps) => {
  return (
    <div className="min-h-screen bg-[#edf2f7] flex font-sans text-slate-800 antialiased">
      
      <Menu />

      <main className="flex-1 p-8 overflow-y-auto max-w-[1600px] mx-auto">
        {props.children}
      </main>
    </div>
  );
};